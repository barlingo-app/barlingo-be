package com.barlingo.backend.security;

public interface IUserAccountService {

  public void changePassword(org.springframework.security.core.userdetails.User principal,
      String username, String secret);
}
