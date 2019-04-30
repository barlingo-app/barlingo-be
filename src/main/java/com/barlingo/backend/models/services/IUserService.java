package com.barlingo.backend.models.services;

import java.util.List;
import com.barlingo.backend.models.dtos.UserEditDTO;
import com.barlingo.backend.models.dtos.UserExchangesDetailsDTO;
import com.barlingo.backend.models.dtos.UserSigninDTO;
import com.barlingo.backend.models.entities.User;

public interface IUserService {

  List<User> findAll();

  User save(User user);

  User findById(Integer id);

  User findByUsername(String username);

  void delete(User user);

  String login(String username, String password);

  User register(UserSigninDTO userData);

  User edit(org.springframework.security.core.userdetails.User principal, UserEditDTO userData);

  User activateDeactivateUser(Integer id);

  User anonymize (Integer id);

  UserExchangesDetailsDTO exportData (org.springframework.security.core.userdetails.User principal, Integer id);

}
