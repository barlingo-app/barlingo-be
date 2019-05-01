package com.barlingo.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
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
    final UserAccount user = userAccountRepository.findByUsername(username);

    return user != null;
  }

  @Override
  public void changePassword(org.springframework.security.core.userdetails.User principal,
      String username, String secret) {
    UserAccount account;
    UserAccount saved;

    Assert.isTrue(!username.isEmpty(), RestError.SIGNED_USERACCOUNT_USERNAME_EMPTY);
    Assert.isTrue(!secret.isEmpty(), RestError.SIGNED_USERACCOUNT_SECRET_EMPTY);
    account = this.userAccountRepository.findByUsername(username);
    Assert.notNull(account, RestError.SIGNED_USERACCOUNT_NOT_EXISTS);

    for (GrantedAuthority authority : principal.getAuthorities()) {
      if (!authority.getAuthority().equals("ROLE_ADMIN")) {
        Assert.isTrue(account.getUsername().equals(principal.getUsername()),
            RestError.SIGNED_USERACCOUNT_CANNOT_MODIFY_OTHER_USERS);
      }
    }

    account.setPassword(passwordEncoder.encode(secret));
    saved = this.userAccountRepository.save(account);
    Assert.notNull(saved, RestError.SIGNED_USERACCOUNT_ERROR_SAVING_ACCOUNT);
  }



}
