package com.barlingo.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.services.EstablishmentServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/establishments")
public class EstablishmentRestController {

	@Autowired
	private EstablishmentServiceImpl establishmentService;

	@GetMapping("/list")
	public List<Establishment> findEstablishments() {
		return this.establishmentService.findAll();
	}

	@GetMapping("/{id}")
	public Establishment show(@PathVariable int id) {
		return this.establishmentService.findById(id);
	}

}
