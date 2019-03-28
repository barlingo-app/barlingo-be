package com.barlingo.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public void save(User user) {
		this.userRepository.save(user);
	}

	public User findById(Integer id) {
		return this.userRepository.findById(id).orElse(null);
	}

	public void delete(User user) {
		this.userRepository.delete(user);
	}


}
