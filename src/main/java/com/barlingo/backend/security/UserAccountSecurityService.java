package com.barlingo.backend.security;

import java.io.IOException;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.barlingo.backend.utilities.RestError;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class UserAccountSecurityService implements UserDetailsService, IUserAccountService {

  @Autowired
  private UserAccountRepository userAccountRepository;

  @Autowired
  @Lazy
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final UserAccount user = userAccountRepository.findByUsername(username);



    if (user == null || !user.getActive()) {
      throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(username)//
        .password(user.getPassword())//
        .authorities(user.getRoles())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

  public Boolean usernameExists(String username) {
    Assert.notNull(username, RestError.ALL_USER_USERNAME_EMPTY);
    final UserAccount user = userAccountRepository.findByUsername(username);

    return user != null;
  }

  @Override
  public void changePassword(org.springframework.security.core.userdetails.User principal,
      String secret) throws IOException {
    UserAccount account;
    UserAccount saved;


    Assert.notNull(principal, RestError.SIGNED_USERACCOUNT_NOT_NULL);
    Assert.notNull(secret, RestError.SIGNED_USERACCOUNT_SECRET_EMPTY);
    Assert.isTrue(!secret.isEmpty(), RestError.SIGNED_USERACCOUNT_SECRET_EMPTY);
    account = this.userAccountRepository.findByUsername(principal.getUsername());
    Assert.notNull(account, RestError.SIGNED_USERACCOUNT_NOT_EXISTS);
    try {
      secret = new String(Base64.getDecoder().decode(secret));
    } catch (Exception e) {
      throw new IOException(RestError.SIGNED_USERACCOUNT_ERROR_DECODING);
    }
    account.setPassword(passwordEncoder.encode(secret));
    saved = this.userAccountRepository.save(account);
    Assert.notNull(saved, RestError.SIGNED_USERACCOUNT_ERROR_SAVING_ACCOUNT);
  }



}
