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
		return this.userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findById(Integer id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(User user) {
		this.userRepository.delete(user);
	}
	
//	public User findByPrincipal() {
//	User result;
//	UserAccount userAccount;
//
//	userAccount = LoginService.getPrincipal();
//	Assert.notNull(userAccount);
//	final Actor actor = this.actorService.findByUserAccount(userAccount);
//	Assert.isTrue(actor instanceof User, "");
//	result = (User) actor;
//	Assert.notNull(result, "");
//
//	return result;
//}
}
