package com.barlingo.backend.controllers;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.dtos.LanguageExchangeGenericDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.services.LanguageExchangeServiceImpl;
import com.barlingo.backend.models.services.UserServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class LanguageExchangeRestController {

  @Autowired
  private LanguageExchangeServiceImpl langExchangeService;
  @Autowired
  private LanguageExchangeMapper langExchangeMapper;
  @Autowired
  private UserServiceImpl userService;

  @GetMapping("/exchanges")
  public List<LanguageExchangeDetailsDTO> findExchange(
      @RequestParam(value = "estId", required = false) Integer estId,
      @RequestParam(value = "userId", required = false) Integer userId) {
	  if (userId != null) {
		  Assert.notNull(this.userService.findById(userId), "user doesn't exist");
		  return this.langExchangeMapper.entitysToDtos(langExchangeService.findAllByUserId(userId));
	  } else {
		  return this.langExchangeMapper.entitysToDtos(langExchangeService.findAll());
	  }


  }

  @GetMapping("/exchanges/{id}")
  public LanguageExchangeDetailsDTO show(@PathVariable Integer id) {
    LanguageExchange langExchEntity = langExchangeService.findById(id);
    LanguageExchangeDetailsDTO langExch = langExchangeMapper.entityToDto(langExchEntity);
    return langExch;
  }

  @PutMapping("/exchanges/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public LanguageExchangeDetailsDTO update(@RequestBody LanguageExchangeDetailsDTO langExchangeDTO,
      @PathVariable Integer id) {
    return new LanguageExchangeDetailsDTO();
  }

  @DeleteMapping("/exchanges/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    LanguageExchange currentLangExchange = this.langExchangeService.findById(id);
    this.langExchangeService.delete(currentLangExchange);
  }

  @PostMapping(path = "/exchanges/{languageExchangeId}/join", consumes = "application/json")
  public LanguageExchangeDetailsDTO joinUser(@PathVariable Integer languageExchangeId,
      @RequestBody Map<String, Integer> langExchangeData) {

    Integer userId = langExchangeData.get("userId");
    return this.langExchangeMapper
        .entityToDto(this.langExchangeService.joinUser(userId, languageExchangeId));
  }

  @PostMapping(path = "/exchanges", consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public LanguageExchangeDetailsDTO create(
      @RequestBody LanguageExchangeGenericDTO langExchangeData) {
    LanguageExchange langExchange = new LanguageExchange();
    langExchange.setTitle(langExchangeData.getTitle());
    langExchange.setDescription(langExchangeData.getDescription());

    LanguageExchangeDetailsDTO result = null;

    try {
      // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
      // langExchange.setMoment(LocalDateTime.parse((String) langExchangeData.get("moment"),
      // formatter));
      langExchange.setMoment(langExchangeData.getMoment());
      Integer creatorId = langExchangeData.getCreatorId();
      Integer establishmentId = langExchangeData.getEstablishmentId();
      langExchange.setTargetLangs(langExchangeData.getTargetLangs());
      langExchange.setNumberMaxParticipants(langExchangeData.getNumberOfParticipants());
      result = this.langExchangeMapper.entityToDto(
          this.langExchangeService.createAndSave(creatorId, establishmentId, langExchange));
    } catch (Exception e) {
      langExchange.setMoment(null);
    }

    return result;
  }
}
