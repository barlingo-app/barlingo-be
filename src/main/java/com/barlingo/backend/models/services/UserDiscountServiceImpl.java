package com.barlingo.backend.models.services;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import com.barlingo.backend.models.entities.Actor;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.repositories.UserDiscountRepository;
import com.barlingo.backend.utilities.RestError;

@Service
@Transactional
public class UserDiscountServiceImpl implements IUserDiscountService {

  @Autowired
  private UserDiscountRepository userDiscountRepository;
  @Autowired
  private IUserService userService;
  @Autowired
  private ILanguageExchangeService languageExchangeService;
  @Autowired
  private IEstablishmentService establishmentService;

  @Override
  public List<UserDiscount> findAll() {
    return this.userDiscountRepository.findAll();
  }

  @Override
  public UserDiscount createAndSave(Integer userId, Integer langExchangeId) {
    UserDiscount udSaved;

    // TODO: Catch principal
    // User user = this.userService.findByPrincipal();
    User user = this.userService.findById(userId);
    Assert.notNull(user, RestError.SIGNED_USERDISCOUNT_USER_NOT_NULL);

    UserDiscount userDiscount = new UserDiscount();
    userDiscount.setCode(this.generateUniqueCode());
    userDiscount.setVisible(false);
    userDiscount.setExchanged(false);
    userDiscount.setLangExchange(this.languageExchangeService.findById(langExchangeId));
    userDiscount.setUser(user);

    udSaved = this.userDiscountRepository.save(userDiscount);
    return udSaved;
  }

  /**
   * Update an existing UserDiscount
   *
   * @return saved
   */
  @Override
  public UserDiscount save(UserDiscount userDiscount) {
    UserDiscount saved;
    Assert.notNull(userDiscount, RestError.SIGNED_USERDISCOUNT_USERDISCOUNT_NOT_NULL);
    Assert.notNull(userDiscount.getUser(), RestError.SIGNED_USERDISCOUNT_USER_NOT_NULL);
    Assert.notNull(userDiscount.getLangExchange(),
        RestError.SIGNED_USERDISCOUNT_LANGUAGE_EXCHANGE_NOT_NULL);

    /* Comprueba que exista el usuario y el intercambio */
    Assert.isTrue(this.userService.findById(userDiscount.getUser().getId()) != null,
        RestError.SIGNED_USERDISCOUNT_USER_NOT_EXISTS);
    Assert.isTrue(
        this.languageExchangeService.findById(userDiscount.getLangExchange().getId()) != null,
        RestError.SIGNED_USERDISCOUNT_LANGUAGE_EXCHANGE_NOT_EXITS);
    /*
     * Comprueba que el usuario del descuento se haya unido al intercambio del descuento
     */
    // Assert.isTrue(userDiscount.getLangExchange().getParticipants().stream().anyMatch(p
    // -> p.getId() == userDiscount.getUser().getId()),
    // USER_NOT_JOINT_IN_USER_DISCOUNT);
    /* Comprueba que el mismo código no pertenezca ya a otro UserDiscount */
    UserDiscount duplicate = this.findByCode(userDiscount.getCode());
    if (duplicate != null && userDiscount.getId() > 0) {
      Assert.isTrue(userDiscount.getId() == duplicate.getId(),
          RestError.SIGNED_USERDISCOUNT_CODE_BELONG_ANOTHER_EXCHANGE);
    }

    saved = this.userDiscountRepository.save(userDiscount);
    Assert.notNull(saved, RestError.SIGNED_USERDISCOUNT_ERROR_SAVING_DISCOUNT);
    return saved;
  }

  @Override
  public UserDiscount findByCode(String code) {
    // User user = this.userService.findByPrincipal();
    // User user = this.userService.findById(1);
    // Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);

    return this.userDiscountRepository.findByCode(code);
  }

  @Override
  public UserDiscount findByLangExchangeId(
      org.springframework.security.core.userdetails.User principal, Integer userId,
      Integer langExchangeId) throws Exception {
    UserDiscount udSaved = null;
    LanguageExchange exchange;
    Actor current;
    Assert.notNull(userId, RestError.SIGNED_USERDISCOUNT_USER_NOT_NULL);
    Assert.notNull(langExchangeId, RestError.SIGNED_USERDISCOUNT_LANGUAGE_EXCHANGE_NOT_NULL);
    current = this.userService.findByUsername(principal.getUsername());
    if (current == null)
      current = this.establishmentService.findByUsername(principal.getUsername());

    exchange = this.languageExchangeService.findById(langExchangeId);
    Assert.notNull(exchange, RestError.SIGNED_USERDISCOUNT_LANGUAGE_EXCHANGE_NOT_NULL);

    if (current.getId() != userId && current.getId() != exchange.getEstablishment().getId())
      throw new Exception(RestError.SIGNED_USERDISCOUNT_ACCESS_FORBIDDEN);

    User user = this.userService.findById(userId);
    Assert.notNull(user, RestError.SIGNED_USERDISCOUNT_USER_NOT_NULL);


    UserDiscount ud =
        this.userDiscountRepository.findByUserIdAndLangExchangeId(userId, langExchangeId);
    Assert.notNull(ud, RestError.SIGNED_USERDISCOUNT_USERDISCOUNT_NOT_NULL);
    // Refresh isVisible 4hours before that languageExchange
    if (ud.getLangExchange().getMoment().minusHours(4).isBefore(LocalDateTime.now())
        && ud.getLangExchange().getMoment().plusHours(48).isAfter(LocalDateTime.now())) {
      ud.setVisible(true);
      udSaved = this.userDiscountRepository.save(ud);
      Assert.notNull(udSaved, RestError.SIGNED_USERDISCOUNT_ERROR_SAVING_DISCOUNT);
    } else if (ud.getVisible()) {
      ud.setVisible(false);
      udSaved = this.userDiscountRepository.save(ud);
      Assert.notNull(udSaved, RestError.SIGNED_USERDISCOUNT_ERROR_SAVING_DISCOUNT);
    }

    // Restrictions
    Assert.isTrue(ud.getVisible(), RestError.SIGNED_USERDISCOUNT_NOT_VISIBLE);

    return udSaved;
  }

  /**
   * Sets discount as exchanged and updates it in the repository
   *
   * @param userDiscount the code to redeem
   * @return saved UserDiscount updated with attrib exchanged set to true
   */
  @Override
  public UserDiscount redeem(org.springframework.security.core.userdetails.User principal,
      UserDiscount userDiscount) {
    UserDiscount saved;

    Assert.isTrue(userDiscount.getLangExchange().getMoment().isBefore(LocalDateTime.now()),
        RestError.ESTABLISHMENT_USERDISCOUNT_LANGUAGE_EXCHANGE_NOT_STARTED_YET);
    Assert.isTrue(this.isValid(principal, userDiscount),
        RestError.ESTABLISHMENT_USERDISCOUNT_CANNOT_BE_EXCHANGED);
    userDiscount.setExchanged(true);
    saved = this.save(userDiscount);
    Assert.notNull(saved, RestError.SIGNED_USERDISCOUNT_ERROR_SAVING_DISCOUNT);

    return saved;
  }

  @Override
  public void delete(UserDiscount discount) {
    this.userDiscountRepository.delete(discount);
  }

  ///////////////////////
  // Auxiliary Methods //
  ///////////////////////

  // public void checkPrincipal(final UserDiscount userDiscount) {
  // final Actor principal = this.actorService.findByPrincipal();
  // User userPrincipal = null;
  // if (principal instanceof User) {
  // userPrincipal = (User) principal;
  // Assert.isTrue(userDiscount.getUser().equals(userPrincipal), "");
  // } else {
  // Assert.isTrue(Boolean.TRUE, "Usuario no válido.");
  // }
  // }

  /**
   * Generate an unique reference
   *
   * @return the reference
   */
  private String generateUniqueCode() {
    final SimpleDateFormat dt = new SimpleDateFormat("ddMMyyyy");
    final Random r = new SecureRandom();
    StringBuilder randomLetter = new StringBuilder();
    String reference = "";

    while (this.checkReference(reference) || reference.equals("")) {
      for (int i = 0; i < 4; i++) {
        randomLetter.append(String.valueOf((char) (r.nextInt(26) + 'A')));
      }

      reference = dt.format(new Date()) + "-" + randomLetter;
    }
    return reference;
  }

  /**
   * Check if exist a coincidence
   */
  private boolean checkReference(final String reference) {
    Boolean result = false;
    if (this.userDiscountRepository.findByCode(reference) != null) {
      result = true;
    }
    return result;
  }

  /**
   * @return True if the discount code is valid, False in other case
   */
  @Override
  public Boolean isValid(org.springframework.security.core.userdetails.User principal,
      UserDiscount userDiscount) {
    Actor current;

    Assert.notNull(userDiscount, RestError.SIGNED_USERDISCOUNT_CODE_NOT_EXISTS);

    current = this.userService.findByUsername(principal.getUsername());
    if (current != null) {
      Assert.isTrue(userDiscount.getLangExchange().getParticipants().contains(current),
          RestError.SIGNED_USERDISCOUNT_ACCESS_FORBIDDEN);
    } else {
      current = this.establishmentService.findByUsername(principal.getUsername());
      Assert.isTrue(userDiscount.getLangExchange().getEstablishment().equals(current),
          RestError.SIGNED_USERDISCOUNT_ACCESS_FORBIDDEN);
    }

    if (userDiscount.getExchanged() || !userDiscount.getVisible()
        || userDiscount.getLangExchange().getMoment().plusHours(48).isBefore(LocalDateTime.now())) {
      return false;
    }

    return true;

  }
}
