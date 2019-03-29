package com.barlingo.backend.controllers;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.services.LanguageExchangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class LanguageExchangeRestController {

	@Autowired
	private LanguageExchangeServiceImpl langExchangeService;
	@Autowired
	private LanguageExchangeMapper langExchangeMapper;

	@GetMapping("/exchanges")
	public List<LanguageExchangeDetailsDTO> findExchange() {
		List<LanguageExchangeDetailsDTO> list = this.langExchangeMapper.entitysToDtos(langExchangeService.findAll());

		return list;
	}

	@GetMapping("/exchanges/{id}")
	public LanguageExchangeDetailsDTO show(@PathVariable Integer id) {
		LanguageExchange langExchEntity = langExchangeService.findById(id);
		LanguageExchangeDetailsDTO langExch = langExchangeMapper.entityToDto(langExchEntity);
		return langExch;

	}

	@PostMapping("/exchanges")
	@ResponseStatus(HttpStatus.CREATED)
	public LanguageExchangeDetailsDTO create(@RequestBody LanguageExchangeDetailsDTO langExchangeDTO) {


		return new LanguageExchangeDetailsDTO();
	}

	
	@PutMapping("/exchanges/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public LanguageExchangeDetailsDTO update(@RequestBody LanguageExchangeDetailsDTO langExchangeDTO, @PathVariable Integer id) {

		return new LanguageExchangeDetailsDTO();
	}

	@DeleteMapping("/exchanges/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		LanguageExchange currentLangExchange = this.langExchangeService.findById(id);
		this.langExchangeService.delete(currentLangExchange);
	}
}
