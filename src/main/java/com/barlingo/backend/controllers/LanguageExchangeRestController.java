package com.barlingo.backend.controllers;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.LanguageExchangeCreateDTO;
import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.services.EstablishmentServiceImpl;
import com.barlingo.backend.models.services.LanguageExchangeServiceImpl;
import com.barlingo.backend.models.services.UserServiceImpl;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.Utils;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/exchanges")
public class LanguageExchangeRestController {

  @Autowired
  private LanguageExchangeServiceImpl langExchangeService;
  @Autowired
  private LanguageExchangeMapper langExchangeMapper;
  @Autowired
  private UserServiceImpl userService;
  @Autowired
  private EstablishmentServiceImpl establishmentService;

  @GetMapping
  public List<LanguageExchangeDetailsDTO> findExchange(
      @RequestParam(value = "estId", required = false) Integer estId,
      @RequestParam(value = "userId", required = false) Integer userId,
      @RequestParam(value = "date", required = false, defaultValue = "true") Boolean upcoming) {
    List<LanguageExchangeDetailsDTO> result;
    LocalDateTime moment = null;

    if (upcoming != null && upcoming)
      moment = LocalDateTime.now();
    if (userId != null) {
      Assert.notNull(this.userService.findById(userId), "user doesn't exist");
      // minus 24 hour till now for grant the users see exchanges of the last 24h and redeem their
      // discount
      if (moment != null)
        moment.minusHours(24);

      result = this.langExchangeMapper
          .entitysToDtos(langExchangeService.findAllByUserId(userId, moment));
    } else if (estId != null) {
      Assert.notNull(this.establishmentService.findById(estId), "establishment doesn't exist");
      result =
          this.langExchangeMapper.entitysToDtos(langExchangeService.findByEstId(estId, moment));
    } else
      result = this.langExchangeMapper.entitysToDtos(langExchangeService.findAll(moment));

    return result;
  }

  @GetMapping("/{id}")
  public LanguageExchangeDetailsDTO show(@PathVariable Integer id) {
    LanguageExchange langExchEntity = langExchangeService.findById(id);
    return langExchangeMapper.entityToDto(langExchEntity);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public LanguageExchangeDetailsDTO update(@RequestBody LanguageExchangeDetailsDTO langExchangeDTO,
      @PathVariable Integer id) {
    return new LanguageExchangeDetailsDTO();
  }

  // @DeleteMapping("/{id}")
  // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  // @ResponseStatus(HttpStatus.NO_CONTENT)
  // public void delete(@PathVariable Integer id) {
  // LanguageExchange currentLangExchange = this.langExchangeService.findById(id);
  // this.langExchangeService.delete(currentLangExchange);
  // }

  @PostMapping("/{languageExchangeId}/join")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public LanguageExchangeDetailsDTO joinUser(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer languageExchangeId) {

    return this.langExchangeMapper
        .entityToDto(this.langExchangeService.joinUser(principal, languageExchangeId));
  }

  @PostMapping("/{languageExchangeId}/leave")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public LanguageExchangeDetailsDTO leaveLanguageExchange(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer languageExchangeId) {

    User user = this.userService.findByUsername(principal.getUsername());
    return this.langExchangeMapper.entityToDto(this.langExchangeService
        .leaveLanguageExchange(principal, user.getId(), languageExchangeId));
  }

  @PostMapping(consumes = "application/json")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ResponseBody> create(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @Valid @RequestBody LanguageExchangeCreateDTO langExchangeData, BindingResult binding) {

    ResponseBody responseBody = new ResponseBody();
    if (binding.hasErrors()) {
      responseBody.setCode(400);
      responseBody.setSuccess(false);
      responseBody.setValidationErrors(Utils.convertValidationErrors(binding));
    } else {
      responseBody.setCode(200);
      responseBody.setSuccess(true);
      responseBody.setContent(this.langExchangeMapper
          .entityToDto(this.langExchangeService.createAndSave(principal, langExchangeData)));
    }

    return ResponseEntity.ok().body(responseBody);
  }
}
