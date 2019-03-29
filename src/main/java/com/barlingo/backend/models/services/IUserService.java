package com.barlingo.backend.models.services;

import java.util.List;

import com.barlingo.backend.models.entities.User;

public interface IUserService {

	List<User> findAll();

	User save(User user);

	User findById(Integer id);

	User findByUsername(String username);

	void delete(User user);

	String signin(String username, String password);

}
