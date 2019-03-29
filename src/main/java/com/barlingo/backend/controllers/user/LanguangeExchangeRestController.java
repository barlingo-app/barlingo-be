package com.barlingo.backend.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.services.ILanguageExchangeService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/laguageExchange/user")
public class LanguangeExchangeRestController {

	@Autowired
	private ILanguageExchangeService languageExchangeService;
	@Autowired
	private LanguageExchangeMapper languangeExchangeMapper;

	@GetMapping("/join/{languageExchangeId}")
	public LanguageExchangeDetailsDTO joinUser(@PathVariable Integer languageExchangeId) {
		return this.languangeExchangeMapper.entityToDto(this.languageExchangeService.joinUser(languageExchangeId));
	}

}
