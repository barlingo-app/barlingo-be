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
import com.barlingo.backend.models.dtos.LanguageExchangeCreateDTO;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.ExchangeState;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.repositories.LanguageExchangeRepository;
import com.barlingo.backend.utilities.RestError;

@Service
@Transactional
public class LanguageExchangeServiceImpl implements ILanguageExchangeService {

  @Autowired
  private LanguageExchangeRepository langExchangeRepository;
  @Autowired
  private IUserService userService;
  @Autowired
  private IUserDiscountService userDiscountService;
  @Autowired
  private IEstablishmentService establishmentService;

  @Override
  public LanguageExchange createAndSave(
      org.springframework.security.core.userdetails.User principal,
      LanguageExchangeCreateDTO langExchange) {
    User user = this.userService.findByUsername(principal.getUsername());

    Assert.notNull(user, RestError.SIGNED_LANGUAGE_EXCHANGE_USER_NOT_NULL);
    Assert.notNull(langExchange, RestError.ALL_LANGUAGE_EXCHANGE_NOT_NULL);
    Assert.isTrue(langExchange.getMoment().isAfter(LocalDateTime.now()),
        RestError.USER_LANGUAGE_EXCHANGE_CANNOT_SAVE_PAST_EXCHANGE);

    LanguageExchange langExch = new LanguageExchange();

    langExch.setCreator(user);
    langExch.setTitle(langExchange.getTitle());
    langExch.setDescription(langExchange.getDescription());
    langExch.setMoment(langExchange.getMoment());
    langExch.setParticipants(new LinkedList<User>());
    langExch.setNumberMaxParticipants(langExchange.getNumberOfParticipants());
    langExch.setExchangeState(ExchangeState.OPEN);
    langExch.setTargetLangs(langExchange.getTargetLangs());
    langExch.setUserDiscounts(new LinkedList<UserDiscount>());

    // Get establishment and check not null
    Establishment establishment =
        this.establishmentService.findById(langExchange.getEstablishmentId());
    Assert.notNull(establishment, RestError.USER_LANGUAGE_EXCHANGE_ESTABLISHMENT_NOT_NULL);
    langExch.setEstablishment(establishment);


    LanguageExchange exchangeSaved = this.langExchangeRepository.save(langExch);
    // Creator join as a participant
    this.joinUser(principal, exchangeSaved.getId());

    return exchangeSaved;
  }

  @Override
  public List<LanguageExchange> findAll(LocalDateTime moment) {
    List<LanguageExchange> res;

    if (moment != null)
      res = this.langExchangeRepository.findByMomentAfterOrderByMomentAsc(moment);
    else
      res = this.langExchangeRepository.findByOrderByMomentDesc();
    return res;
  }

  @Override
  public LanguageExchange save(LanguageExchange exchange) {
    LanguageExchange saved;
    saved = this.langExchangeRepository.save(exchange);
    Assert.notNull(saved, RestError.USER_LANGUAGE_EXCHANGE_ERROR_SAVING_EXCHANGE);
    return saved;
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
      Integer languageExchangeId) {

    User user = this.userService.findByUsername(principal.getUsername());
    Assert.notNull(user, RestError.USER_LANGUAGE_EXCHANGE_USER_NOT_FOUND);
    for (GrantedAuthority authority : principal.getAuthorities()) {
      if (!authority.getAuthority().equals("ROLE_ADMIN")) {
        User userPrincipal = this.userService.findByUsername(principal.getUsername());
        Assert.isTrue(user.equals(userPrincipal),
            RestError.USER_LANGUAGE_EXCHANGE_CANNOT_MODIFY_OTHER_USERS);
      }
    }

    LanguageExchange langExchangeSaved;
    LanguageExchange langExchange = this.findById(languageExchangeId);
    Assert.notNull(langExchange, RestError.SIGNED_LANGUAGE_EXCHANGE_NOT_FOUND);

    Assert.isTrue(langExchange.getMoment().isAfter(LocalDateTime.now()),
        RestError.USER_LANGUAGE_EXCHANGE_EVENT_FINALIZED);
    Assert.isTrue(langExchange.getParticipants().size() < langExchange.getNumberMaxParticipants(),
        RestError.USER_LANGUAGE_EXCHANGE_IS_FULL);


    if (langExchange.getMoment().isAfter(LocalDateTime.now())) {
      Collection<LanguageExchange> userExchanges = user.getLangsExchanges();
      Assert.isTrue(!user.getLangsExchanges().contains(langExchange),
          RestError.USER_LANGUAGE_EXCHANGE_ALREADY_REGISTERED);

      userExchanges.add(langExchange);
      user.setLangsExchanges(userExchanges);

      Collection<User> participants = langExchange.getParticipants();

      participants.add(this.userService.save(user));
      langExchange.setParticipants(participants);

      // Generate new code to new participant
      this.userDiscountService.createAndSave(user.getId(), languageExchangeId);
    }
    langExchangeSaved = this.save(langExchange);

    return langExchangeSaved;
  }

  @Override
  public LanguageExchange leaveLanguageExchange(
      org.springframework.security.core.userdetails.User principal, Integer userId,
      Integer languageExchangeId) {
    User user = this.userService.findById(userId);
    Assert.notNull(user, RestError.USER_LANGUAGE_EXCHANGE_USER_NOT_NULL);
    for (GrantedAuthority authority : principal.getAuthorities()) {
      if (!authority.getAuthority().equals("ROLE_ADMIN")) {
        User userPrincipal = this.userService.findByUsername(principal.getUsername());
        Assert.isTrue(user.equals(userPrincipal),
            RestError.USER_LANGUAGE_EXCHANGE_CANNOT_MODIFY_OTHER_USERS);
      }
    }

    LanguageExchange langExchangeSaved;
    LanguageExchange langExchange = this.findById(languageExchangeId);
    Assert.notNull(langExchange, RestError.SIGNED_LANGUAGE_EXCHANGE_NOT_FOUND);

    Assert.isTrue(langExchange.getMoment().isAfter(LocalDateTime.now()),
        RestError.USER_LANGUAGE_EXCHANGE_EVENT_FINALIZED);

    if (langExchange.getMoment().isAfter(LocalDateTime.now())) {
      Collection<LanguageExchange> userExchanges = user.getLangsExchanges();
      Assert.isTrue(user.getLangsExchanges().contains(langExchange),
          RestError.USER_LANGUAGE_EXCHANGE_USER_NOT_REGISTERED);

      userExchanges.remove(langExchange);
      user.setLangsExchanges(userExchanges);

      Collection<User> participants = langExchange.getParticipants();
      Assert.isTrue(langExchange.getParticipants().contains(user),
          RestError.USER_LANGUAGE_EXCHANGE_USER_NOT_REGISTERED);

      participants.remove(this.userService.save(user));
      langExchange.setParticipants(participants);

      // Generate new code to new participant
      this.userDiscountService.createAndSave(userId, languageExchangeId);
    }
    langExchangeSaved = this.save(langExchange);

    return langExchangeSaved;
  }

  @Override
  public List<LanguageExchange> findByEstId(Integer estId, LocalDateTime moment) {

    List<LanguageExchange> res;
    if (moment != null)
      res = (List<LanguageExchange>) this.langExchangeRepository.findByEstIdAndMomentAfter(estId,
          moment);
    else
      res = (List<LanguageExchange>) this.langExchangeRepository.findByEstId(estId);
    return res;
  }

  @Override
  public List<LanguageExchange> findAllByUserId(Integer userId, LocalDateTime moment) {

    List<LanguageExchange> res;
    if (moment != null)
      res = this.langExchangeRepository.findAllByUserIdAndMomentAfter(userId, moment);
    else
      res = this.langExchangeRepository.findAllByUserId(userId);
    return res;
  }
}
