package com.barlingo.backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.barlingo.backend.models.entities.Actor;
import com.barlingo.backend.models.entities.Admin;
import com.barlingo.backend.models.entities.Configuration;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.ExchangeState;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.Notification;
import com.barlingo.backend.models.entities.NotificationPriority;
import com.barlingo.backend.models.entities.PayData;
import com.barlingo.backend.models.entities.Role;
import com.barlingo.backend.models.entities.SubscriptionData;
import com.barlingo.backend.models.entities.SubscriptionType;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.repositories.AdminRepository;
import com.barlingo.backend.models.repositories.ConfigurationRepository;
import com.barlingo.backend.models.repositories.EstablishmentRepository;
import com.barlingo.backend.models.repositories.LanguageExchangeRepository;
import com.barlingo.backend.models.repositories.NotificationRepository;
import com.barlingo.backend.models.repositories.PayDataRepository;
import com.barlingo.backend.models.repositories.SubscriptionDataRepository;
import com.barlingo.backend.models.repositories.UserDiscountRepository;
import com.barlingo.backend.models.repositories.UserRepository;
import com.barlingo.backend.models.services.IUploadFileService;
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
  AdminRepository adminRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  PayDataRepository paydataRepository;
  @Autowired
  SubscriptionDataRepository subscriptionRepository;
  @Autowired
  EstablishmentRepository establishmentRepository;
  @Autowired
  LanguageExchangeRepository languageExchangeRepository;
  @Autowired
  UserDiscountRepository userDiscountRepository;

  @Autowired
  NotificationRepository notificationRepository;

  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  IUploadFileService uploadFileService;

  @Override
  public void run(String... args) throws Exception {
    log.info("=== Initialize files directory ===");
    this.uploadFileService.init();

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
          .paypalVendorId("AG3N8JTUR4SNA") //
          .build());

      log.info("== Admin ==");
      Admin admin = this.adminRepository.save(createAdmin("admin", "admin", "España", "Sevilla",
          "admin@barlingo.es", "admin", "admin"));

      log.info("== Users ==");
      User user1 = createUser("Cristina Alba", "Kuroiwa", "España", "Sevilla",
          "username1@gmail.com", "username1", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/4_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/EKZ9QLRKFC.jpg",
          Date.from(LocalDate.of(1993, 8, 27).atStartOfDay(ZoneId.of("UTC")).toInstant()),
          Arrays.asList("es"), Arrays.asList("en", "de"), "es");
      User user2 = createUser("David", "Rodríguez Pérez", "España", "Sevilla",
          "username2@gmail.com", "username2", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/10_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/2SFV3ZUNWZ.jpg",
          Date.from(LocalDate.of(1991, 2, 26).atStartOfDay(ZoneId.of("UTC")).toInstant()),
          Arrays.asList("es"), Arrays.asList("en", "de"), "es");
      User user3 = createUser("David", "Panadero Molina", "España", "Sevilla",
          "username3@gmail.com", "username3", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/7_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/8BK8Y8YQLH.jpg",
          Date.from(LocalDate.of(1990, 2, 26).atStartOfDay(ZoneId.of("UTC")).toInstant()),
          Arrays.asList("es"), Arrays.asList("en", "de", "fr"), "es");
      User user4 = createUser("Francisco Javier", "Toucedo Campos", "España", "Sevilla",
          "username4@gmail.com", "username4", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/12_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/HWWGZ3RNXT.jpg",
          Date.from(LocalDate.of(1991, 7, 12).atStartOfDay(ZoneId.of("UTC")).toInstant()),
          Arrays.asList("es"), Arrays.asList("en"), "es");
      User user5 = createUser("María", "Muñoz de Burgos", "España", "Sevilla",
          "username5@gmail.com", "username5", "username",
          "https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/3_avatar-128.png",
          "https://cdn.stocksnap.io/img-thumbs/280h/DHQEELXOQZ.jpg",
          Date.from(LocalDate.of(1991, 12, 21).atStartOfDay(ZoneId.of("UTC")).toInstant()),
          Arrays.asList("es"), Arrays.asList("en"), "es");

      log.info("== PayData ==");
      PayData payData1 = createPayData("Pago de Echate P'Alla Tapas", "1RV07592WN284744T",
          LocalDateTime.of(2019, 1, 1, 10, 00));
      PayData payData2 = createPayData("Pago de MonteCristo", "1RV07592WN284744T",
          LocalDateTime.of(2019, 1, 1, 10, 00));
      PayData payData3 = createPayData("Pago de Ronda el Alamillo", "1RV07592WN284744T",
          LocalDateTime.of(2019, 1, 1, 10, 00));
      PayData payData4 = createPayData("Pago de Oneills", "1RV07592WN284744T",
          LocalDateTime.of(2019, 1, 1, 10, 00));

      log.info("== Subscriptions ==");
      SubscriptionData subscription1 =
          createSubscriptionData(payData1.getMoment(), SubscriptionType.ANNUAL,
              config.getPriceMonthSubscription()
                  - config.getPriceMonthSubscription() * config.getAnnualDiscount(),
              payData1, payData1.getMoment().plusMonths(SubscriptionType.ANNUAL.getType()));
      SubscriptionData subscription2 =
          createSubscriptionData(payData2.getMoment(), SubscriptionType.TRIMESTRAL,
              config.getPriceMonthSubscription()
                  - config.getPriceMonthSubscription() * config.getTrimestralDiscount(),
              payData2, payData2.getMoment().plusMonths(SubscriptionType.TRIMESTRAL.getType()));
      SubscriptionData subscription3 =
          createSubscriptionData(payData3.getMoment(), SubscriptionType.ANNUAL,
              config.getPriceMonthSubscription()
                  - config.getPriceMonthSubscription() * config.getAnnualDiscount(),
              payData3, payData3.getMoment().plusMonths(SubscriptionType.ANNUAL.getType()));
      SubscriptionData subscription4 = createSubscriptionData(payData4.getMoment(),
          SubscriptionType.MONTHLY, config.getPriceMonthSubscription(), payData4,
          payData4.getMoment().plusMonths(SubscriptionType.MONTHLY.getType()));

      log.info("== Establishments ==");
      Establishment establishment1 = createEstablishment("Ruben", "Rodríguez Pérez", "España",
          "Sevilla", "establishment1@gmail.com", "establishment1", "establishment",
          "Echate P'Alla Tapas", "Avenida de Sevilla 40",
          Arrays
              .asList("https://media-cdn.tripadvisor.com/media/photo-f/16/5e/b9/05/photo0jpg.jpg"),
          "https://media-cdn.tripadvisor.com/media/photo-f/16/5e/b9/05/photo0jpg.jpg",
          "monday tuesday wednesday thursday friday saturday sunday,06:00-00:00",
          "Cerveceza y tapa 1.50€", subscription1);
      Establishment establishment2 = createEstablishment("Juan Miguel", "Luza León", "España",
          "Sevilla", "establishment2@gmail.com", "establishment2", "establishment",
          "Ronda el Alamillo", "Ronda el Alamillo",
          Arrays
              .asList("https://lh3.ggpht.com/p/AF1QipNV-xAbmrfJuowSV7520cght4Fd6tZH-5uN5YYd=s1024"),
          "https://lh3.ggpht.com/p/AF1QipNV-xAbmrfJuowSV7520cght4Fd6tZH-5uN5YYd=s1024",
          "monday tuesday wednesday thursday friday saturday sunday,06:00-00:00", "Cerveceza 0.90€",
          subscription2);
      Establishment establishment3 = createEstablishment("Evaristo", "Ramírez Calvo", "España",
          "Sevilla", "establishment1@gmail.com", "establishment3", "establishment",
          "MONTECRISTO TERRAZA-BAR", "Calle Albareda, 16",
          Arrays.asList("http://media.tilllate.es/images/locations/ri_locbild1439178.jpg"),
          "http://media.tilllate.es/images/locations/ri_locbild1439178.jpg",
          "monday tuesday wednesday thursday friday saturday sunday,06:00-00:00", "Cerveceza 0.90€",
          subscription3);
      Establishment establishment4 = createEstablishment("Eduardo", "Pérez Gonzalez", "España",
          "Sevilla", "establishment1@gmail.com", "establishment4", "establishment",
          "O'Neill's Irish Pub", "Calle Adriano, 34",
          Arrays.asList(
              "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/10897916_894861150544946_4193659117013254471_n.jpg?_nc_cat=106&_nc_ht=scontent-mad1-1.xx&oh=50cf3bdfb9ec6e6632dd6842f4bbcbee&oe=5D442DD8"),
          "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/10897916_894861150544946_4193659117013254471_n.jpg?_nc_cat=106&_nc_ht=scontent-mad1-1.xx&oh=50cf3bdfb9ec6e6632dd6842f4bbcbee&oe=5D442DD8",
          "monday tuesday wednesday thursday friday saturday sunday,06:00-00:00", "Cerveceza 0.90€",
          subscription4);

      log.info("== Language Exchanges ==");
      LanguageExchange langExchange1 = createLanguageExchange("Quedada en Los Palacios",
          "Language Exchange 1", LocalDateTime.of(2019, 1, 21, 10, 00), ExchangeState.CLOSE, 3,
          Arrays.asList("es", "en"), establishment1, user1, Arrays.asList(user1, user2),
          Arrays.asList());
      LanguageExchange langExchange2 = createLanguageExchange("Intercambio Inglés/Español",
          "Language Exchange 2", LocalDateTime.of(2019, 10, 5, 21, 00), ExchangeState.OPEN, 2,
          Arrays.asList("es", "en"), establishment1, user3, Arrays.asList(user3, user2),
          Arrays.asList());
      LanguageExchange langExchange3 = createLanguageExchange("¿Quién se apunta?",
          "Language Exchange 3", LocalDateTime.of(2019, 6, 21, 10, 00), ExchangeState.OPEN, 3,
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

      log.info("== User Notifications ==");
      Notification notification =
          createNotificationList("Alerta Seguridad", "Se ha producido un ataque al sistema",
              Arrays.asList(user1, user2, user3, user4, user5, establishment1, establishment2, establishment3, establishment4), user1);

      log.info("=== Finalize Populate Database ===");
    }

  }

  private Admin createAdmin(String name, String surname, String country, String city, String email,
      String username, String password) {
    Admin admin = new Admin();
    admin.setName(name);
    admin.setSurname(surname);
    admin.setCountry(country);
    admin.setCity(city);
    admin.setEmail(email);
    UserAccount userAccount = new UserAccount();
    userAccount.setUsername(username);
    userAccount.setPassword(this.passwordEncoder.encode(password));
    userAccount.setRoles(Arrays.asList(Role.ROLE_ADMIN));
    userAccount.setActive(true);
    admin.setUserAccount(userAccount);

    return admin;
  }

  private User createUser(String name, String surname, String country, String city, String email,
      String username, String password, String personalPic, String profileBackPic, Date birthday,
      Collection<String> speakLangs, Collection<String> langsToLearn, String motherTongue) {
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

  private PayData createPayData(String title, String orderId, LocalDateTime moment) {
    PayData paydata = PayData.builder() //
        .title(title) //
        .orderId(orderId) //
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

  private Notification createNotificationList(String title, String description,
      List<Actor> receivers, Actor user) {
    Notification notification = new Notification();
    notification.setTitle(title);
    notification.setDescription(description);
    notification.setMoment(LocalDateTime.now());
    notification.setPriority(NotificationPriority.TOP);

    for (Actor receiver : receivers) {
      notification.addReceiver(receiver);
    }

    return this.notificationRepository.saveAndFlush(notification);
  }

}

