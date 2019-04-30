package com.barlingo.backend.models.services;

import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.barlingo.backend.exception.CustomException;
import com.barlingo.backend.models.dtos.EstablishmentCreateDTO;
import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.dtos.EstablishmentExchangesDetailsDTO;
import com.barlingo.backend.models.dtos.LanguageExchangeGenericDTO;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.Role;
import com.barlingo.backend.models.mapper.EstablishmentMapper;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.repositories.ConfigurationRepository;
import com.barlingo.backend.models.repositories.EstablishmentRepository;
import com.barlingo.backend.security.UserAccount;
import com.barlingo.backend.security.UserAccountRepository;
import com.barlingo.backend.utilities.RestError;
import com.barlingo.backend.utilities.Utils;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class EstablishmentServiceImpl implements IEstablishmentService {

  @Autowired
  private UserAccountRepository userAccountRepository;

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private EstablishmentMapper establishmentMapper;

  @Autowired
  private ILanguageExchangeService languageExchangeService;

  @Autowired
  private LanguageExchangeMapper languageExchangeMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  ConfigurationRepository configRepository;


  @Override
  public List<Establishment> findAll() {
    return this.establishmentRepository.findAll();
  }

  @Override
  public Establishment save(Establishment establishment) {
    Establishment saved = this.establishmentRepository.saveAndFlush(establishment);
    Assert.notNull(saved, RestError.ESTABLISHMENT_ESTABLISHMENT_ERROR_SAVING_ESTABLISHMENT);
    return saved;
  }

  @Override
  public Establishment findById(Integer id) {
    Establishment establishment = this.establishmentRepository.findById(id).orElse(null);
    Assert.notNull(establishment, "Establishment id not exist.");

    return establishment;
  }

  @Override
  public void delete(Establishment establishment) {
    this.establishmentRepository.delete(establishment);
  }

  @Override
  public Establishment findByUsername(String username) {
    UserAccount userAccount = userAccountRepository.findByUsername(username);
    if (userAccount == null) {
      return null;
    }
    return this.establishmentRepository.findByUserAccountId(userAccount.getId());
  }

  @Override
  public Establishment register(EstablishmentCreateDTO establishmentData) {

    Establishment establishment = create();

    establishment.getUserAccount().setUsername(establishmentData.getUsername());
    establishment.getUserAccount()
        .setPassword(passwordEncoder.encode(establishmentData.getPassword()));
    establishment.getUserAccount().setActive(true);
    establishment.setEstablishmentName(establishmentData.getEstablishmentName());
    establishment.setName(establishmentData.getName());
    establishment.setSurname(establishmentData.getSurname());
    establishment.setEmail(establishmentData.getEmail());
    establishment.setCity(establishmentData.getCity());
    establishment.setCountry(establishmentData.getCountry());
    establishment.setWorkingHours(establishmentData.getWorkingHours());
    establishment.setAddress(establishmentData.getAddress());
    establishment.setDescription(establishmentData.getDescription());
    establishment.setOffer(establishmentData.getOffer());

    /*
     * //Create pay data PayData payData = createPayData(establishmentData);
     *
     * //Create subscription data SubscriptionData subscriptionData =
     * createSubscription(establishmentData,payData);
     *
     * establishment.setSubscription(subscriptionData);
     */

    return save(establishment);
  }

  @Override
  public Establishment edit(org.springframework.security.core.userdetails.User principal,
      EstablishmentDetailsDTO establishmentData) {

    Assert.notNull(establishmentData,
        RestError.ESTABLISHMENT_ESTABLISHMENT_ESTABLISHMENT_DATA_NOT_NULL);
    Establishment establishment = this.findByUsername(principal.getUsername());
    Assert.notNull(establishment, RestError.ESTABLISHMENT_ESTABLISHMENT_NOT_FOUND);

    for (GrantedAuthority authority : principal.getAuthorities()) {
      if (!authority.getAuthority().equals("ROLE_ADMIN")) {
        Establishment establishmentPrincipal = this.findByUsername(principal.getUsername());
        Assert.isTrue(establishment.equals(establishmentPrincipal),
            RestError.ESTABLISHMENT_ESTABLISHMENT_CANNOT_MODIFY_OTHER_USER);
      }
    }

    establishment.setEstablishmentName(establishmentData.getEstablishmentName());
    establishment.setName(establishmentData.getName());
    establishment.setEmail(establishmentData.getEmail());
    establishment.setCity(establishmentData.getCity());
    establishment.setCountry(establishmentData.getCountry());
    establishment.setWorkingHours(establishmentData.getWorkingHours());
    establishment.setAddress(establishmentData.getAddress());
    establishment.setDescription(establishmentData.getDescription());
    establishment.setOffer(establishmentData.getOffer());

    return save(establishment);
  }

  private Establishment create() {
    Establishment establishment = new Establishment();
    establishment.setUserAccount(new UserAccount());
    establishment.getUserAccount().setRoles(new ArrayList<>());
    establishment.getUserAccount().getRoles().add(Role.ROLE_ESTABLISHMENT);
    // establishment.setNotifications(new ArrayList<>());

    return establishment;
  }

  @Override
  public List<Establishment> findByDateGreater(LocalDateTime date) {
    Assert.notNull(date);
    return this.establishmentRepository.findByDateGreater(date);
  }

  @Override
  public Establishment activateDeactivateUser(Integer id) {
    final Establishment establishment = this.findById(id);
    Assert.notNull(establishment,
        String.format(RestError.ESTABLISHMENT_ESTABLISHMENT_NOT_FOUND, id));

    establishment.getUserAccount().setActive(!establishment.getUserAccount().getActive());

    return this.save(establishment);
  }

  @Override
  public Establishment anonymize(Integer id) {
    final String anonymousString = "Anonymous_";
    Establishment establishment = this.findById(id);

    try {
      establishment.setName(anonymousString + Utils.getHashSha1(establishment.getName()));
      establishment.setSurname(anonymousString + Utils.getHashSha1(establishment.getSurname()));
      establishment.setAddress(anonymousString + Utils.getHashSha1(establishment.getAddress()));
      establishment
          .setDescription(anonymousString + Utils.getHashSha1(establishment.getDescription()));
      establishment.setEstablishmentName(
          anonymousString + Utils.getHashSha1(establishment.getEstablishmentName()));
      establishment.setOffer(anonymousString + Utils.getHashSha1(establishment.getOffer()));
      establishment.setCountry(anonymousString + Utils.getHashSha1(establishment.getCountry()));
      establishment.setCity(anonymousString + Utils.getHashSha1(establishment.getCity()));
      establishment.getUserAccount().setActive(false);

    } catch (NoSuchAlgorithmException e) {
      throw new CustomException(RestError.ANONYMIZE_PROCESS_ERROR, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    return this.save(establishment);
  }

  @Override
  public EstablishmentExchangesDetailsDTO exportData(
      org.springframework.security.core.userdetails.User principal, Integer establishmentId) {
    InputStream targetStream = null;

    EstablishmentDetailsDTO establishmentDetailsDTO =
        this.establishmentMapper.establishmentToDto(this.findById(establishmentId));

    for (GrantedAuthority authority : principal.getAuthorities()) {
      if (!authority.getAuthority().equals("ROLE_ADMIN")) {
        Establishment establishmentPrincipal = this.findByUsername(principal.getUsername());
        Assert.isTrue(establishmentDetailsDTO.getId().equals(establishmentPrincipal.getId()),
            RestError.ESTABLISHMENT_ESTABLISHMENT_CANNOT_ACCESS_OTHER_USERS_DATA);
      }
    }

    List<LanguageExchangeGenericDTO> languageExchangeGenericDTOS = this.languageExchangeMapper
        .entitiesToDtosGeneric(languageExchangeService.findByEstId(establishmentId, null));

    EstablishmentExchangesDetailsDTO establishmentExchangesDetailsDTO =
        new EstablishmentExchangesDetailsDTO();
    establishmentExchangesDetailsDTO.setEstablishmentDetailsDTO(establishmentDetailsDTO);
    establishmentExchangesDetailsDTO.setLangsExchanges(languageExchangeGenericDTOS);

    return establishmentExchangesDetailsDTO;

  }

  /*
   * private SubscriptionData createSubscription(EstablishmentDetailsDTO establishmentData, PayData
   * payData) { //Subscription data SubscriptionData subscriptionData = SubscriptionData.builder()
   * // .initMoment(payData.getMoment()) //
   * .subscriptionType(establishmentData.getSubscription().getSubscriptionType()) //
   * .paydata(payData) // .price(calculateSubscriptionPrice(
   * establishmentData.getSubscription().getSubscriptionType())) // .finishMoment(
   * payData.getMoment().plusMonths(
   * establishmentData.getSubscription().getSubscriptionType().getMonths())) // .build(); return
   * this.subscriptionRepository.saveAndFlush(subscriptionData);
   *
   * }
   *
   *
   * private PayData createPayData(EstablishmentDetailsDTO establishmentData) { //Pay data PayData
   * paydata = PayData.builder() //
   * .title(establishmentData.getSubscription().getPaydata().getTitle()) //
   * .moment(establishmentData.getSubscription().getPaydata().getMoment()) //
   * .payType(establishmentData.getSubscription().getPaydata().getPayType()) // .build();
   *
   * return this.paydataRepository.saveAndFlush(paydata); }
   *
   * private Double calculateSubscriptionPrice(SubscriptionType subscriptionType) { Configuration
   * config = this.configRepository.findAll().get(0); Double price = 0.0;
   *
   * switch (subscriptionType) { case ANNUAL: price = config.getPriceMonthSubscription() -
   * config.getPriceMonthSubscription() * config.getAnnualDiscount(); break; case TRIMESTRAL: price
   * = config.getPriceMonthSubscription() - config.getPriceMonthSubscription() *
   * config.getTrimestralDiscount(); break; default: price = config.getPriceMonthSubscription(); }
   *
   * return price;
   *
   * }
   */

}
