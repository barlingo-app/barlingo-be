package com.barlingo.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.mapper.EstablishmentMapper;
import com.barlingo.backend.models.services.IEstablishmentService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/establishment/user")
public class EstablishmentRestController {

	@Autowired
	private IEstablishmentService establishmentService;
	@Autowired
	private EstablishmentMapper establishmentMapper;

	@GetMapping("/list")
	public List<EstablishmentGenericDTO> findAllEstablishments() {
		return this.establishmentMapper.establishmentsToDtos(this.establishmentService.findAll());
	}

	@GetMapping("/show/{estId}")
	public Establishment show(@PathVariable int estId) {
		return this.establishmentService.findById(estId);
	}

}
