package com.barlingo.backend.controllers;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.services.LanguageExchangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class LanguageExchangeRestController {

	@Autowired
	private LanguageExchangeServiceImpl langExchangeService;
	@Autowired
	private LanguageExchangeMapper langExchangeMapper;

	@GetMapping("/exchanges")
	public List<LanguageExchangeDetailsDTO> findExchange(@RequestParam(value = "estId", required=false) Integer estId)
	{
		return this.langExchangeMapper.entitysToDtos(langExchangeService.findAll());

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

	@PostMapping(path = "/{languageExchangeId}/join", consumes = "application/json")
	public LanguageExchangeDetailsDTO joinUser(@PathVariable Integer languageExchangeId,
											   @RequestBody Map<String,String> langExchangeData) {

		Integer userId = Integer.valueOf(langExchangeData.get("id"));
		return this.langExchangeMapper
				.entityToDto(this.langExchangeService.joinUser(userId, languageExchangeId));
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public LanguageExchangeDetailsDTO create(@RequestBody Map<String,Object> langExchangeData) {
		LanguageExchange langExchange = new LanguageExchange();
		langExchange.setTitle((String) langExchangeData.get("title"));
		langExchange.setDescription((String) langExchangeData.get("description"));

		LanguageExchangeDetailsDTO result = null;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
			formatter.setLenient(false);
			langExchange.setMoment(formatter.parse((String)langExchangeData.get("moment")));
			Integer creatorId = (Integer)langExchangeData.get("creatorId");
			Integer establishmentId = (Integer)langExchangeData.get("establishmentId");
			result =  this.langExchangeMapper
					.entityToDto(this.langExchangeService.createAndSave(creatorId, establishmentId, langExchange));
		} catch (Exception e) {
			langExchange.setMoment(null);
		}

		return result;
	}
}
