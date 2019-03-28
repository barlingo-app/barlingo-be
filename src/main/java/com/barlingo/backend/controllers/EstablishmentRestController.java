package com.barlingo.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.services.IEstablishmentService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class EstablishmentRestController {

	@Autowired
	private IEstablishmentService establishmentService;

	@GetMapping("/establishments")
	private List<Establishment> findAllEstablishments() {
		return (List<Establishment>) this.establishmentService.findAll();
	}

	@GetMapping("/establishments/{id}")
	public Establishment show(@PathVariable int id) {
		return this.establishmentService.findById(id);
	}

}
