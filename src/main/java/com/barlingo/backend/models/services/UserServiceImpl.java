package com.barlingo.backend.models.services;

import com.barlingo.backend.exception.CustomException;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.repositories.UserRepository;
import com.barlingo.backend.security.JwtTokenProvider;
import com.barlingo.backend.security.UserAccount;
import com.barlingo.backend.security.UserAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

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

  @Override
  public List<User> findAll() {
    return this.userRepository.findAll();
  }

  @Override
  public User save(User user) {
    return this.userRepository.save(user);
  }

  @Override
  public User findById(Integer id) {
    return this.userRepository.findById(id).orElse(null);
  }

  @Override
  public User findByUsername(String username) {
    UserAccount userAccount = userAccountRepository.findByUsername(username);
    return this.userRepository.findByUserAccountId(userAccount.getId());
  }

  @Override
  public void delete(User user) {
    this.userRepository.delete(user);
  }

  public String signin(String username, String password) {
    try {
      authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(username, password));
      UserAccount user = userAccountRepository.findByUsername(username);
      return jwtTokenProvider.createToken(username, user.getId(), user.getRoles());
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied",
          HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

}
