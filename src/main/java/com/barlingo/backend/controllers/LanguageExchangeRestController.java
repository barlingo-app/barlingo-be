package com.barlingo.backend.controllers;

import java.util.ArrayList;
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

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.dtos.LanguageExchangeGenericDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.services.ILanguageExchangeService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class LanguageExchangeRestController {

	@Autowired
	private ILanguageExchangeService langExchangeService;

	@GetMapping("/exchanges")
	public List<LanguageExchangeGenericDTO> findUser() {
		/*
		 * List<LanguageExchange> langExchanges = langExchangeService.findAll(); return
		 * langExchanges;
		 */

		return new ArrayList<>();

	}

	@GetMapping("/exchanges/{id}")
	public LanguageExchangeDetailsDTO show(@PathVariable Integer id) {

//		return this.langExchangeService.findById(id);

		return new LanguageExchangeDetailsDTO();
	}

	@PostMapping("/exchanges")
	@ResponseStatus(HttpStatus.CREATED)
	public LanguageExchangeDetailsDTO create(@RequestBody LanguageExchangeDetailsDTO langExchangeDTO) {
		/*
		 * this.langExchangeService.save(langExchange); return langExchange;
		 */

		return new LanguageExchangeDetailsDTO();
	}

	@PutMapping("/exchanges/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public LanguageExchangeDetailsDTO update(@RequestBody LanguageExchangeDetailsDTO langExchangeDTO,
			@PathVariable Integer id) {
		/*
		 * LanguageExchange currentLangExchange = this.langExchangeService.findById(id);
		 * this.langExchangeService.save(currentLangExchange); return
		 * currentLangExchange;
		 */

		return new LanguageExchangeDetailsDTO();
	}

	@DeleteMapping("/exchanges/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		LanguageExchange currentLangExchange = this.langExchangeService.findById(id);
		this.langExchangeService.delete(currentLangExchange);
	}
}
