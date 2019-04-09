package com.barlingo.backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.barlingo.backend.models.entities.Configuration;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.ExchangeState;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.PayData;
import com.barlingo.backend.models.entities.Role;
import com.barlingo.backend.models.entities.SubscriptionData;
import com.barlingo.backend.models.entities.SubscriptionType;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.repositories.ConfigurationRepository;
import com.barlingo.backend.models.repositories.EstablishmentRepository;
import com.barlingo.backend.models.repositories.LanguageExchangeRepository;
import com.barlingo.backend.models.repositories.PaydataRepository;
import com.barlingo.backend.models.repositories.SubscriptionDataRepository;
import com.barlingo.backend.models.repositories.UserDiscountRepository;
import com.barlingo.backend.models.repositories.UserRepository;
import com.barlingo.backend.security.UserAccount;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

  @Value("${spring.jpa.hibernate.ddl-auto}")
  private String dbCreationStrategy;
  @Autowired
  ConfigurationRepository configRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  PaydataRepository paydataRepository;
  @Autowired
  SubscriptionDataRepository subscriptionRepository;
  @Autowired
  EstablishmentRepository establishmentRepository;
  @Autowired
  LanguageExchangeRepository languageExchangeRepository;
  @Autowired
  UserDiscountRepository userDiscountRepository;
  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {

    if (!"none".equalsIgnoreCase(dbCreationStrategy)) {
      log.info("=== Initialize Populate Database ===");
      log.info("== Configuration ==");
      Configuration config = this.configRepository.save(Configuration.builder() //
          .companyName("Barlingo") //
          .languagesCode(Arrays.asList("es", "fr", "en", "de")) //
          .priceMonthSubscription(6.99) //
          .trimestralDiscount(0.1) //
          .annualDiscount(0.25) //
          .timeJoinUserToExchange(10) //
          .timeShowBeforeDiscount(4) //
          .timeShowAfterDiscount(24) //
          .build());

      log.info("== Users ==");
      User user1 = createUser("Cristina Alba", "Kuroiwa", "España", "Sevilla",
          "username1@gmail.com", "username1", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/4_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/EKZ9QLRKFC.jpg", LocalDate.of(1993, 8, 27),
          Arrays.asList("es"), Arrays.asList("en", "de"), "es");
      User user2 = createUser("David", "Rodríguez Pérez", "España", "Sevilla",
          "username2@gmail.com", "username2", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/10_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/2SFV3ZUNWZ.jpg", LocalDate.of(1991, 2, 26),
          Arrays.asList("es"), Arrays.asList("en", "de"), "es");
      User user3 = createUser("David", "Panadero Molina", "España", "Sevilla",
          "username3@gmail.com", "username3", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/7_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/8BK8Y8YQLH.jpg", LocalDate.of(1990, 2, 26),
          Arrays.asList("es"), Arrays.asList("en", "de", "fr"), "es");
      User user4 = createUser("Francisco Javier", "Toucedo Campos", "España", "Sevilla",
          "username4@gmail.com", "username4", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/12_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/HWWGZ3RNXT.jpg", LocalDate.of(1991, 7, 12),
          Arrays.asList("es"), Arrays.asList("en"), "es");
      User user5 = createUser("María", "Muñoz de Burgos", "España", "Sevilla",
          "username5@gmail.com", "username5", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/3_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/DHQEELXOQZ.jpg", LocalDate.of(1991, 12, 21),
          Arrays.asList("es"), Arrays.asList("en"), "es");

      log.info("== PayData ==");
      PayData payData1 =
          createPayData("Pago de Echate P'Alla Tapas", LocalDateTime.of(2019, 1, 1, 10, 00));
      PayData payData2 = createPayData("Pago de MonteCristo", LocalDateTime.of(2019, 1, 1, 10, 00));
      PayData payData3 =
          createPayData("Pago de Ronda el Alamillo", LocalDateTime.of(2019, 1, 1, 10, 00));
      PayData payData4 = createPayData("Pago de Oneills", LocalDateTime.of(2019, 1, 1, 10, 00));

      log.info("== Subscriptions ==");
      SubscriptionData subscription1 =
          createSubscriptionData(payData1.getMoment(), SubscriptionType.ANNUAL,
              config.getPriceMonthSubscription()
                  - config.getPriceMonthSubscription() * config.getAnnualDiscount(),
              payData1, payData1.getMoment().plusMonths(SubscriptionType.ANNUAL.getMonths()));
      SubscriptionData subscription2 =
          createSubscriptionData(payData2.getMoment(), SubscriptionType.TRIMESTRAL,
              config.getPriceMonthSubscription()
                  - config.getPriceMonthSubscription() * config.getTrimestralDiscount(),
              payData2, payData2.getMoment().plusMonths(SubscriptionType.TRIMESTRAL.getMonths()));
      SubscriptionData subscription3 =
          createSubscriptionData(payData3.getMoment(), SubscriptionType.ANNUAL,
              config.getPriceMonthSubscription()
                  - config.getPriceMonthSubscription() * config.getAnnualDiscount(),
              payData3, payData3.getMoment().plusMonths(SubscriptionType.ANNUAL.getMonths()));
      SubscriptionData subscription4 = createSubscriptionData(payData4.getMoment(),
          SubscriptionType.MONTHLY, config.getPriceMonthSubscription(), payData4,
          payData4.getMoment().plusMonths(SubscriptionType.MONTHLY.getMonths()));

      log.info("== Establishments ==");
      Establishment establishment1 = createEstablishment("Ruben", "Rodríguez Pérez", "España",
          "Sevilla", "establishment1@gmail.com", "establishment1", "establishment",
          "Echate P'Alla Tapas", "Avenida de Sevilla 40",
          Arrays
              .asList("https://media-cdn.tripadvisor.com/media/photo-f/16/5e/b9/05/photo0jpg.jpg"),
          "https://media-cdn.tripadvisor.com/media/photo-f/16/5e/b9/05/photo0jpg.jpg",
          "06:00 - 00:00", "Cerveceza y tapa 1.50€", subscription1);
      Establishment establishment2 = createEstablishment("Juan Miguel", "Luza León", "España",
          "Sevilla", "establishment2@gmail.com", "establishment2", "establishment",
          "Ronda el Alamillo", "Ronda el Alamillo",
          Arrays
              .asList("https://lh3.ggpht.com/p/AF1QipNV-xAbmrfJuowSV7520cght4Fd6tZH-5uN5YYd=s1024"),
          "https://lh3.ggpht.com/p/AF1QipNV-xAbmrfJuowSV7520cght4Fd6tZH-5uN5YYd=s1024",
          "06:00 - 00:00", "Cerveceza 0.90€", subscription2);
      Establishment establishment3 = createEstablishment("Evaristo", "Ramírez Calvo", "España",
          "Sevilla", "establishment1@gmail.com", "establishment3", "establishment",
          "MONTECRISTO TERRAZA-BAR", "Calle Albareda, 16",
          Arrays.asList("http://media.tilllate.es/images/locations/ri_locbild1439178.jpg"),
          "http://media.tilllate.es/images/locations/ri_locbild1439178.jpg", "06:00 - 00:00",
          "Cerveceza 0.90€", subscription3);
      Establishment establishment4 = createEstablishment("Evaristo", "Ramírez Calvo", "España",
          "Sevilla", "establishment1@gmail.com", "establishment4", "establishment",
          "O'Neill's Irish Pub", "Calle Adriano, 34",
          Arrays.asList(
              "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/10897916_894861150544946_4193659117013254471_n.jpg?_nc_cat=106&_nc_ht=scontent-mad1-1.xx&oh=50cf3bdfb9ec6e6632dd6842f4bbcbee&oe=5D442DD8"),
          "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/10897916_894861150544946_4193659117013254471_n.jpg?_nc_cat=106&_nc_ht=scontent-mad1-1.xx&oh=50cf3bdfb9ec6e6632dd6842f4bbcbee&oe=5D442DD8",
          "06:00 - 00:00", "Cerveceza 0.90€", subscription4);

      log.info("== Language Exchanges ==");
      LanguageExchange langExchange1 = createLanguageExchange("Language Exchange 1",
          "Language Exchange 1", LocalDateTime.of(2019, 1, 21, 10, 00), ExchangeState.CLOSE, 3,
          Arrays.asList("es", "en"), establishment1, user1, Arrays.asList(user1, user2),
          Arrays.asList());
      LanguageExchange langExchange2 = createLanguageExchange("Language Exchange 2",
          "Language Exchange 2", LocalDateTime.of(2019, 10, 5, 21, 00), ExchangeState.OPEN, 2,
          Arrays.asList("es", "en"), establishment1, user3, Arrays.asList(user3, user2),
          Arrays.asList());
      LanguageExchange langExchange3 = createLanguageExchange("Language Exchange 3",
          "Language Exchange 3", LocalDateTime.of(2019, 5, 21, 10, 00), ExchangeState.OPEN, 3,
          Arrays.asList("es", "en"), establishment1, user1, Arrays.asList(user1, user2, user4),
          Arrays.asList());

      log.info("== User Discounts ==");
      UserDiscount userDiscount1 =
          createUserDiscount("20190121-WERW", true, true, user1, langExchange1);
      UserDiscount userDiscount2 =
          createUserDiscount("20190121-WERE", true, true, user2, langExchange1);
      UserDiscount userDiscount3 =
          createUserDiscount("20190121-WERA", true, false, user3, langExchange2);
      UserDiscount userDiscount4 =
          createUserDiscount("20190121-WERQ", true, false, user2, langExchange2);
      UserDiscount userDiscount5 =
          createUserDiscount("20190121-WERR", false, false, user1, langExchange3);
      UserDiscount userDiscount6 =
          createUserDiscount("20190121-WERF", false, false, user2, langExchange3);
      UserDiscount userDiscount7 =
          createUserDiscount("20190121-WERO", false, false, user3, langExchange3);

      log.info("=== Finalize Populate Database ===");
    }

  }

  private User createUser(String name, String surname, String country, String city, String email,
      String username, String password, String personalPic, String profileBackPic,
      LocalDate birthday, Collection<String> speakLangs, Collection<String> langsToLearn,
      String motherTongue) {
    User user = new User();
    user.setName(name);
    user.setSurname(surname);
    user.setCountry(country);
    user.setCity(city);
    user.setEmail(email);
    UserAccount userAccount = new UserAccount();
    userAccount.setUsername(username);
    userAccount.setPassword(this.passwordEncoder.encode(password));
    userAccount.setRoles(Arrays.asList(Role.ROLE_USER));
    userAccount.setActive(true);
    user.setUserAccount(userAccount);
    user.setNotifications(Arrays.asList());
    user.setPersonalPic(personalPic);
    user.setProfileBackPic(profileBackPic);
    user.setAboutMe("");
    user.setBirthday(birthday);
    user.setLocation("");
    user.setSpeakLangs(speakLangs);
    user.setLangsToLearn(langsToLearn);
    user.setMotherTongue(motherTongue);
    user.setLangsExchanges(Arrays.asList());
    return this.userRepository.saveAndFlush(user);
  }

  private Establishment createEstablishment(String name, String surname, String country,
      String city, String email, String username, String password, String establishmentName,
      String address, Collection<String> images, String imageProfile, String workingHours,
      String offer, SubscriptionData subscription) {
    Establishment establishment = new Establishment();
    establishment.setName(name);
    establishment.setSurname(surname);
    establishment.setCountry(country);
    establishment.setCity(city);
    establishment.setEmail(email);
    UserAccount userAccount = new UserAccount();
    userAccount.setUsername(username);
    userAccount.setPassword(this.passwordEncoder.encode(password));
    userAccount.setRoles(Arrays.asList(Role.ROLE_ESTABLISHMENT));
    userAccount.setActive(true);
    establishment.setUserAccount(userAccount);
    establishment.setNotifications(Arrays.asList());
    establishment.setEstablishmentName(establishmentName);
    establishment.setDescription("");
    establishment.setAddress(address);
    establishment.setImages(images);
    establishment.setImageProfile(imageProfile);
    establishment.setWorkingHours(workingHours);
    establishment.setOffer(offer);
    establishment.setSubscription(subscription);
    establishment.setLangsExchange(Arrays.asList());
    return this.establishmentRepository.saveAndFlush(establishment);
  }

  private PayData createPayData(String title, LocalDateTime moment) {
    PayData paydata = PayData.builder() //
        .title(title) //
        .moment(moment) //
        .payType("Paypal") //
        .build();
    return this.paydataRepository.saveAndFlush(paydata);
  }

  private SubscriptionData createSubscriptionData(LocalDateTime initMoment,
      SubscriptionType subscriptionType, Double price, PayData paydata,
      LocalDateTime finishMoment) {
    SubscriptionData subscriptionData = SubscriptionData.builder() //
        .initMoment(initMoment) //
        .subscriptionType(subscriptionType) //
        .paydata(paydata) //
        .price(price) //
        .finishMoment(finishMoment) //
        .build();
    return this.subscriptionRepository.saveAndFlush(subscriptionData);
  }

  private LanguageExchange createLanguageExchange(String title, String description,
      LocalDateTime moment, ExchangeState exchangeState, Integer numberMaxParticipants,
      Collection<String> targetLangs, Establishment establishment, User creator,
      Collection<User> participants, Collection<UserDiscount> userDiscounts) {
    LanguageExchange langExchange = new LanguageExchange();
    langExchange.setTitle(title);
    langExchange.setDescription(description);
    langExchange.setMoment(moment);
    langExchange.setExchangeState(exchangeState);
    langExchange.setNumberMaxParticipants(numberMaxParticipants);
    langExchange.setTargetLangs(targetLangs);
    langExchange.setEstablishment(establishment);
    langExchange.setCreator(creator);
    langExchange.setParticipants(participants);
    langExchange.setUserDiscounts(userDiscounts);
    return this.languageExchangeRepository.saveAndFlush(langExchange);
  }

  private UserDiscount createUserDiscount(String code, Boolean visible, Boolean exchanged,
      User user, LanguageExchange langExchange) {
    UserDiscount userDiscount = UserDiscount.builder() //
        .code(code) //
        .visible(visible) //
        .exchanged(exchanged) //
        .user(user) //
        .langExchange(langExchange) //
        .build();
    return this.userDiscountRepository.saveAndFlush(userDiscount);
  }
}

