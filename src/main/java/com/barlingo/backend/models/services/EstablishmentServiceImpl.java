package com.barlingo.backend.models.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.entities.Actor;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.Role;
import com.barlingo.backend.models.repositories.ActorRepository;
import com.barlingo.backend.models.repositories.ConfigurationRepository;
import com.barlingo.backend.models.repositories.EstablishmentRepository;
import com.barlingo.backend.security.JwtTokenProvider;
import com.barlingo.backend.security.UserAccount;
import com.barlingo.backend.security.UserAccountRepository;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class EstablishmentServiceImpl implements IEstablishmentService {

  @Autowired
  private ActorRepository actorRepository;

  @Autowired
  private UserAccountRepository userAccountRepository;

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  ConfigurationRepository configRepository;

  @Autowired
  private Validator validator;


  @Override
  public List<Establishment> findAll() {
    return this.establishmentRepository.findAll();
  }

  @Override
  public Establishment save(Establishment establishment) {
    return this.establishmentRepository.saveAndFlush(establishment);
  }

  @Override
  public Establishment findById(Integer id) {
    return this.establishmentRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Establishment establishment) {
    this.establishmentRepository.delete(establishment);
  }

  @Override
  public Actor findByUsername(String username) {
    UserAccount userAccount = userAccountRepository.findByUsername(username);
    if (userAccount == null) {
      return null;
    }
    return this.actorRepository.findByUserAccountId(userAccount.getId());
  }

  @Override
  public Establishment register(EstablishmentDetailsDTO establishmentData, BindingResult binding) {

    validator.validate(establishmentData, binding);
    Assert.isTrue(!binding.hasErrors());

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
  public Establishment edit(Integer id, EstablishmentDetailsDTO establishmentData,
      BindingResult binding) {

    validator.validate(establishmentData, binding);
    Assert.isTrue(!binding.hasErrors());

    Establishment establishment = findById(id);

    Assert.notNull(establishmentData, "Establishment not found");

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

    return save(establishment);
  }

  private Establishment create() {
    Establishment establishment = new Establishment();
    establishment.setUserAccount(new UserAccount());
    establishment.getUserAccount().setRoles(new ArrayList<>());
    establishment.getUserAccount().getRoles().add(Role.ROLE_ESTABLISHMENT);
    establishment.setNotifications(new ArrayList<>());

    return establishment;
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
