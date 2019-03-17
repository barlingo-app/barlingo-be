package com.barlingo.backend.models.services;

import java.util.List;

import com.barlingo.backend.models.entities.User;

public interface IUserService {

	List<User> findAll();

	void save(User user);

	User findById(Integer id);

	void delete(User user);
}
