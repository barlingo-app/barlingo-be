package com.barlingo.backend.security;

import java.io.IOException;

public interface IUserAccountService {

  public void changePassword(org.springframework.security.core.userdetails.User principal,
      String secret) throws IOException;
}
