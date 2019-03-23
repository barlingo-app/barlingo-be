package com.barlingo.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return (List<User>) this.userRepository.findAll();
	}

	@Override
	public void save(User user) {
		this.userRepository.save(user);
	}

	@Override
	public User findById(Integer id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(User user) {
		this.userRepository.delete(user);
	}
}
