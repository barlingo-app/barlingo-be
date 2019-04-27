package com.barlingo.backend.models.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import com.barlingo.backend.exception.CustomException;
import com.barlingo.backend.models.dtos.UserEditDTO;
import com.barlingo.backend.models.dtos.UserSigninDTO;
import com.barlingo.backend.models.entities.Actor;
import com.barlingo.backend.models.entities.Role;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.repositories.ActorRepository;
import com.barlingo.backend.models.repositories.UserRepository;
import com.barlingo.backend.security.JwtTokenProvider;
import com.barlingo.backend.security.UserAccount;
import com.barlingo.backend.security.UserAccountRepository;
import com.barlingo.backend.utilities.RestError;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Autowired
  private ActorRepository actorRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserAccountRepository userAccountRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;


  private User create() {
    User user = new User();
    user.setUserAccount(new UserAccount());
    user.getUserAccount().setRoles(new ArrayList<>());
    user.getUserAccount().getRoles().add(Role.ROLE_USER);
    user.setLangsExchanges(new ArrayList<>());
    // user.setNotifications(new ArrayList<>());

    return user;
  }

  @Override
  public List<User> findAll() {
    return this.userRepository.findAll();
  }

  @Override
  public User save(User user) {
    User saved;
    saved = this.userRepository.save(user);
    Assert.notNull(saved, RestError.USER_USER_ERROR_SAVING_USER);
    return saved;
  }

  @Override
  public User findById(Integer id) {
    return this.userRepository.findById(id).orElse(null);
  }

  @Override
  public User findByUsername(String username) {
    UserAccount userAccount = userAccountRepository.findByUsername(username);
    if (userAccount == null) {
      return null;
    }
    return this.userRepository.findByUserAccountId(userAccount.getId());
  }

  @Override
  public void delete(User user) {
    this.userRepository.delete(user);
  }

  @Override
  public String login(String username, String password) {
    try {
      authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(username, password));

      UserAccount userAccount = userAccountRepository.findByUsername(username);
      // Assert.isTrue(userAccount.getActive(), "User banned.");
      Actor actor = actorRepository.findByUserAccountId(userAccount.getId());
      return jwtTokenProvider.createToken(username, actor.getId(), userAccount.getRoles());
    } catch (AuthenticationException e) {
      throw new CustomException(RestError.UNSIGNED_WRONG_USERNAME_OR_PASS,
          HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }


  @Override
  public User edit(org.springframework.security.core.userdetails.User principal,
      UserEditDTO userData) {

    User user = this.findById(userData.getId());
    Assert.notNull(user, RestError.USER_USER_NOT_FOUND);

    for (GrantedAuthority authority : principal.getAuthorities()) {
      if (!authority.getAuthority().equals("ROLE_ADMIN")) {
        User userPrincipal = this.findByUsername(principal.getUsername());
        Assert.isTrue(user.equals(userPrincipal), RestError.USER_USER_CANNOT_MODIFY_OTHER_USERS);
      }
    }

    user.setName(userData.getName());
    user.setSurname(userData.getSurname());
    user.setEmail(userData.getEmail());
    user.setCity(userData.getCity());
    user.setCountry(userData.getCountry());
    user.setAboutMe(userData.getAboutMe());
    user.setBirthday(userData.getBirthdate());
    user.setSpeakLangs(userData.getSpeakLanguages());
    user.setLangsToLearn(userData.getLearnLanguages());
    user.setMotherTongue(userData.getMotherTongue());
    user.setPersonalPic(userData.getPersonalPic());

    return save(user);
  }

  @Override
  public User register(UserSigninDTO userData, BindingResult binding) {

    User user = create();
    User saved;

    user.getUserAccount().setUsername(userData.getUsername());
    user.getUserAccount().setPassword(passwordEncoder.encode(userData.getPassword()));
    user.getUserAccount().setActive(true);
    user.setName(userData.getName());
    user.setSurname(userData.getSurname());
    user.setEmail(userData.getEmail());
    user.setCity(userData.getCity());
    user.setCountry(userData.getCountry());
    user.setAboutMe(userData.getAboutMe());
    user.setBirthday(userData.getBirthdate());
    user.setSpeakLangs(userData.getSpeakLanguages());
    user.setLangsToLearn(userData.getLearnLanguages());
    user.setMotherTongue(userData.getMotherTongue());
    saved = save(user);
    Assert.notNull(saved, RestError.USER_USER_ERROR_SAVING_USER);
    return saved;
  }

  @Override
  public User activateDeactivateUser(Integer id) {
    final User user = this.findById(id);
    Assert.notNull(user, RestError.USER_USER_NOT_FOUND);

    user.getUserAccount().setActive(!user.getUserAccount().getActive());

    return this.save(user);
  }

}
