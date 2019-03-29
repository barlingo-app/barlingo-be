package com.barlingo.backend.controllers.establishment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.dtos.LanguageExchangeGenericDTO;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.services.ILanguageExchangeService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/languageExchange/establishment")
public class EstablishmentLanguangeExchangeRestController {

	@Autowired
	private ILanguageExchangeService languageExchangeService;
	@Autowired
	private LanguageExchangeMapper languageExchangeMapper;
	
	@GetMapping("/details/{exId}")
	public LanguageExchangeDetailsDTO findExchange(@PathVariable Integer exId) {
		return this.languageExchangeMapper.entityToDto(languageExchangeService.findById(exId));
	}
	
	@GetMapping("/list/{estId}")
	public List<LanguageExchangeGenericDTO> findExchangesByEstId(@PathVariable Integer estId) {
		return this.languageExchangeMapper.entitiesToDtosGeneric(languageExchangeService.findByEstId(estId));
	}

}
