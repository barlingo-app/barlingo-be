package com.barlingo.backend.controllers;

import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.mapper.EstablishmentMapper;
import com.barlingo.backend.models.services.IEstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/establishments")
public class EstablishmentRestController {

	@Autowired
	private IEstablishmentService establishmentService;
	@Autowired
	private EstablishmentMapper establishmentMapper;

	@GetMapping("")
	public List<EstablishmentGenericDTO> findAllEstablishments() {
		return this.establishmentMapper.establishmentsToDtos(this.establishmentService.findAll());
	}

	@GetMapping("/{estId}")
	public EstablishmentDetailsDTO show(@PathVariable int estId) {
		return this.establishmentMapper.establishmentToDto(this.establishmentService.findById(estId));
	}

	@GetMapping("/show/{username}")
	public EstablishmentDetailsDTO findByUsername(@PathVariable String username) {
		return this.establishmentMapper.establishmentToDto(this.establishmentService.findByUsername(username));
	}

}
