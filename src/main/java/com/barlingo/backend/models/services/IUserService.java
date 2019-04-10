package com.barlingo.backend.models.services;

import java.util.List;
import org.springframework.validation.BindingResult;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.forms.UserEdit;
import com.barlingo.backend.models.forms.UserSignin;

public interface IUserService {

  List<User> findAll();

  User save(User user);

  User findById(Integer id);

  User findByUsername(String username);

  void delete(User user);

  String login(String username, String password);

  User register(UserSignin userData, BindingResult binding);

  User edit(UserEdit userData, BindingResult binding);

  User activateDeactivateUser(Integer id);

}
