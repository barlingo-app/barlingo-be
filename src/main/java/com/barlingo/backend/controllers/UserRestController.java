package com.barlingo.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.services.UserServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class UserRestController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/users")
	public List<User> findUser() {
		List<User> users = userService.findAll();
		return users;
	}

	@GetMapping("/users/{id}")
	public User show(@PathVariable Integer id) {
		return this.userService.findById(id);
	}

	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		this.userService.save(user);
		return user;
	}

	@PutMapping("/users/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User update(@RequestBody User user, @PathVariable Integer id) {
		User currentCliente = this.userService.findById(id);
		currentCliente.setSurname(user.getName());
		currentCliente.setSurname(user.getSurname());
		currentCliente.setEmail(user.getEmail());
		this.userService.save(currentCliente);
		return currentCliente;
	}

	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		User currentUser = this.userService.findById(id);
		this.userService.delete(currentUser);
	}
}
