package com.barlingo.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.dtos.UserDetailsDTO;
import com.barlingo.backend.models.mapper.UserMapper;
import com.barlingo.backend.models.services.IUserService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private IUserService userService;
	@Autowired
	private UserMapper userMapper;

	@GetMapping("/list")
	public List<UserDetailsDTO> findUser() {
		return this.userMapper.entitysToDtos(userService.findAll());
	}

	@GetMapping("/{id}")
	public UserDetailsDTO show(@PathVariable Integer id) {
		return this.userMapper.entityToDto(this.userService.findById(id));
	}

//	@PostMapping("/users")
//	@ResponseStatus(HttpStatus.CREATED)
//	public User create(@RequestBody User user) {
//		this.userService.save(user);
//		return user;
//	}

//	@PutMapping("/users/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public User update(@RequestBody User user, @PathVariable Integer id) {
//		User currentCliente = this.userService.findById(id);
//		currentCliente.setSurname(user.getName());
//		currentCliente.setSurname(user.getSurname());
//		currentCliente.setEmail(user.getEmail());
//		this.userService.save(currentCliente);
//		return currentCliente;
//	}

//	@DeleteMapping("/users/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Integer id) {
//		User currentUser = this.userService.findById(id);
//		this.userService.delete(currentUser);
//	}
}
