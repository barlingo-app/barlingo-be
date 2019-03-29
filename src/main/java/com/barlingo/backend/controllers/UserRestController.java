package com.barlingo.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.services.IUserService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class UserRestController {

	@Autowired
	private IUserService userService;

	@GetMapping("/users")
	public List<User> findUser() {
		List<User> users = userService.findAll();
		return users;
	}

	@GetMapping("/users/{id}")
	public User show(@PathVariable Integer id) {
		return this.userService.findById(id);
	}

	@GetMapping("/users/username/{username}")
	public User findByUsername(@PathVariable String username) {
		return this.userService.findByUsername(username);
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

	@PostMapping("/users/signin")
	public String login(//
						@RequestParam String username, //
						@RequestParam String password) {
		return userService.signin(username, password);
	}
}
