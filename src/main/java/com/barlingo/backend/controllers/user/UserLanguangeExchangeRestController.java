package com.barlingo.backend.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.services.ILanguageExchangeService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/languageExchange/user")
public class UserLanguangeExchangeRestController {

	@Autowired
	private ILanguageExchangeService languageExchangeService;
	@Autowired
	private LanguageExchangeMapper languageExchangeMapper;

	@PostMapping("/join/{languageExchangeId}")
	public LanguageExchangeDetailsDTO joinUser(@RequestParam Integer userId, @PathVariable Integer languageExchangeId) {
		return this.languageExchangeMapper
				.entityToDto(this.languageExchangeService.joinUser(userId, languageExchangeId));
	}
	
	@GetMapping("/details/{exId}")
	public LanguageExchangeDetailsDTO findExchange(@PathVariable Integer exId) {
		return this.languageExchangeMapper.entityToDto(languageExchangeService.findById(exId));
	}
	
	@GetMapping("/list")
	public List<LanguageExchangeDetailsDTO> findExchange() {
		return this.languageExchangeMapper.entitysToDtos(languageExchangeService.findAll());
	}
	
	@PostMapping(path = "/create", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public LanguageExchangeDetailsDTO create(@RequestParam Integer creatorId, @RequestParam Integer establishmentId,
			@RequestBody LanguageExchange langExchange) {
		return this.languageExchangeMapper
				.entityToDto(this.languageExchangeService.createAndSave(creatorId, establishmentId, langExchange));
	}

}
