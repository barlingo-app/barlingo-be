package com.barlingo.backend.controllers;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.dtos.LanguageExchangeGenericDTO;
import com.barlingo.backend.models.dtos.UserDetailsDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.services.LanguageExchangeServiceImpl;
import com.barlingo.backend.models.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class LanguageExchangeRestController {

	@Autowired
	private LanguageExchangeServiceImpl langExchangeService;

	@GetMapping("/exchanges")
	public List<LanguageExchangeGenericDTO> findUser() {
		/*List<LanguageExchange> langExchanges = langExchangeService.findAll();
		return langExchanges;*/

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
		/*this.langExchangeService.save(langExchange);
		return langExchange;*/

		return new LanguageExchangeDetailsDTO();
	}

	@PutMapping("/exchanges/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public LanguageExchangeDetailsDTO update(@RequestBody LanguageExchangeDetailsDTO langExchangeDTO, @PathVariable Integer id) {
		/*LanguageExchange currentLangExchange = this.langExchangeService.findById(id);
		this.langExchangeService.save(currentLangExchange);
		return currentLangExchange;*/

		return new LanguageExchangeDetailsDTO();
	}

	@DeleteMapping("/exchanges/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		LanguageExchange currentLangExchange = this.langExchangeService.findById(id);
		this.langExchangeService.delete(currentLangExchange);
	}
}
