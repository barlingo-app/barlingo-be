package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import com.barlingo.backend.models.entities.ExchangeState;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.repositories.LanguageExchangeRepository;

@Service
@Transactional
public class LanguageExchangeServiceImpl implements ILanguageExchangeService {

  private static final String USER_NOT_NULL_IN_CREATE_USER_DISCOUNT =
      "User not null in create UserDiscount";
  private static final String LANGEXCHANGE_NOT_NULL_IN_CREATE_USER_DISCOUNT =
      "Language Exchange can not be null";
  @Autowired
  private LanguageExchangeRepository langExchangeRepository;
  @Autowired
  private IUserService userService;
  @Autowired
  private IUserDiscountService userDiscountService;
  @Autowired
  private IEstablishmentService establishmentService;

  @Override
  public LanguageExchange createAndSave(Integer creatorId, Integer establishmentId,
      LanguageExchange langExchange) {
    User user = this.userService.findById(creatorId);

    Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);
    Assert.notNull(langExchange, LANGEXCHANGE_NOT_NULL_IN_CREATE_USER_DISCOUNT);
    Assert.isTrue(langExchange.getMoment().isAfter(LocalDateTime.now()),
        "This moment is past, can't save this exchange");

    LanguageExchange langExch = new LanguageExchange();

    langExch.setCreator(user);
    langExch.setTitle(langExchange.getTitle());
    langExch.setDescription(langExchange.getDescription());
    langExch.setMoment(langExchange.getMoment());
    langExch.setParticipants(new LinkedList<User>());
    langExch.setNumberMaxParticipants(langExchange.getNumberMaxParticipants());
    langExch.setExchangeState(ExchangeState.OPEN);
    langExch.setEstablishment(this.establishmentService.findById(establishmentId));
    langExch.setTargetLangs(langExchange.getTargetLangs());
    langExch.setUserDiscounts(new LinkedList<UserDiscount>());

    return this.langExchangeRepository.save(langExch);
  }

  @Override
  public List<LanguageExchange> findAll() {
    return this.langExchangeRepository.findAll();
  }

  @Override
  public List<LanguageExchange> findAllActual() {
    return this.langExchangeRepository.findByMomentAfter(LocalDateTime.now());
  }

  @Override
  public LanguageExchange save(LanguageExchange exchange) {
    return this.langExchangeRepository.save(exchange);
  }

  @Override
  public LanguageExchange findById(Integer id) {
    return this.langExchangeRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(LanguageExchange exchange) {
    this.langExchangeRepository.delete(exchange);
  }

  @Override
  public LanguageExchange joinUser(org.springframework.security.core.userdetails.User principal,
      Integer userId, Integer languageExchangeId) {

    User user = this.userService.findById(userId);
    Assert.notNull(user, "User not found.");
    for (GrantedAuthority authority : principal.getAuthorities()) {
      if (!authority.getAuthority().equals("ROLE_ADMIN")) {
        User userPrincipal = this.userService.findByUsername(principal.getUsername());
        Assert.isTrue(user.equals(userPrincipal), "You can not modify other users.");
      }
    }

    LanguageExchange langExchangeSaved;
    LanguageExchange langExchange = this.findById(languageExchangeId);
    Assert.notNull(langExchange, "Invalid language exchange");

    Assert.isTrue(langExchange.getMoment().isAfter(LocalDateTime.now()),
        "Event has already taken place");


    if (langExchange.getMoment().isAfter(LocalDateTime.now())) {
      Collection<LanguageExchange> userExchanges = user.getLangsExchanges();
      Assert.isTrue(!user.getLangsExchanges().contains(langExchange), "You already register");

      userExchanges.add(langExchange);
      user.setLangsExchanges(userExchanges);

      Collection<User> participants = langExchange.getParticipants();
      Assert.isTrue(!langExchange.getParticipants().contains(user), "You already register");

      participants.add(this.userService.save(user));
      langExchange.setParticipants(participants);

      // Generate new code to new participant
      this.userDiscountService.createAndSave(userId, languageExchangeId);
    }
    langExchangeSaved = this.save(langExchange);

    return langExchangeSaved;
  }

  @Override
  public LanguageExchange leaveLanguageExchange(
      org.springframework.security.core.userdetails.User principal, Integer userId,
      Integer languageExchangeId) {

    User user = this.userService.findById(userId);
    for (GrantedAuthority authority : principal.getAuthorities()) {
      if (!authority.getAuthority().equals("ROLE_ADMIN")) {
        User userPrincipal = this.userService.findByUsername(principal.getUsername());
        Assert.isTrue(user.equals(userPrincipal), "You can not modify other users.");
      }
    }

    LanguageExchange langExchangeSaved;
    LanguageExchange langExchange = this.findById(languageExchangeId);
    Assert.notNull(langExchange, "Invalid language exchange");

    Assert.isTrue(langExchange.getMoment().isAfter(LocalDateTime.now()),
        "Event has already taken place");

    if (langExchange.getMoment().isAfter(LocalDateTime.now())) {
      Collection<LanguageExchange> userExchanges = user.getLangsExchanges();
      Assert.isTrue(user.getLangsExchanges().contains(langExchange),
          "You not register in this language exchange");

      userExchanges.remove(langExchange);
      user.setLangsExchanges(userExchanges);

      Collection<User> participants = langExchange.getParticipants();
      Assert.isTrue(langExchange.getParticipants().contains(user),
          "You not register in this language exchange");

      participants.remove(this.userService.save(user));
      langExchange.setParticipants(participants);

      // Generate new code to new participant
      this.userDiscountService.createAndSave(userId, languageExchangeId);
    }
    langExchangeSaved = this.save(langExchange);

    return langExchangeSaved;
  }

  @Override
  public List<LanguageExchange> findByEstId(Integer estId) {
    return (List<LanguageExchange>) this.langExchangeRepository.findByEstId(estId);
  }

  @Override
  public List<LanguageExchange> findAllByUserId(Integer userId) {
    return this.langExchangeRepository.findAllByUserId(userId);
  }
}
