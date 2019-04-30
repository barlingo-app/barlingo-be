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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.LanguageExchangeCreateDTO;
import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.mapper.LanguageExchangeMapper;
import com.barlingo.backend.models.services.EstablishmentServiceImpl;
import com.barlingo.backend.models.services.LanguageExchangeServiceImpl;
import com.barlingo.backend.models.services.UserServiceImpl;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.RestError;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/exchanges")
public class LanguageExchangeRestController extends AbstractRestController {

  @Autowired
  private LanguageExchangeServiceImpl langExchangeService;
  @Autowired
  private LanguageExchangeMapper langExchangeMapper;
  @Autowired
  private UserServiceImpl userService;
  @Autowired
  private EstablishmentServiceImpl establishmentService;

  @GetMapping
  public ResponseEntity<ResponseBody> findExchange(
      @RequestParam(value = "estId", required = false) Integer estId,
      @RequestParam(value = "userId", required = false) Integer userId,
      @RequestParam(value = "date", required = false, defaultValue = "true") Boolean upcoming) {
    ResponseEntity<ResponseBody> result;
    List<LanguageExchangeDetailsDTO> exchanges;
    LocalDateTime moment = null;

    try {
      if (upcoming != null && upcoming)
        moment = LocalDateTime.now();
      if (userId != null) {
        Assert.notNull(this.userService.findById(userId),
            RestError.SIGNED_LANGUAGE_EXCHANGE_USER_NOT_EXISTS);
        // minus 24 hour till now for grant the users see exchanges of the last 24h and redeem their
        // discount
        if (moment != null)
          moment.minusHours(24);

        exchanges = this.langExchangeMapper
            .entitysToDtos(langExchangeService.findAllByUserId(userId, moment));
      } else if (estId != null) {
        Assert.notNull(this.establishmentService.findById(estId),
            RestError.SIGNED_LANGUAGE_EXCHANGE_ESTABLISHMENT_NOT_EXISTS);
        exchanges =
            this.langExchangeMapper.entitysToDtos(langExchangeService.findByEstId(estId, moment));
      } else
        exchanges = this.langExchangeMapper.entitysToDtos(langExchangeService.findAll(moment));

      result = this.createResponse(exchanges);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }

    return result;
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseBody> show(@PathVariable Integer id) {
    ResponseEntity<ResponseBody> result;
    try {
      LanguageExchangeDetailsDTO exchange =
          langExchangeMapper.entityToDto(langExchangeService.findById(id));
      result = this.createResponse(exchange);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  // @PutMapping("/{id}")
  // @ResponseStatus(HttpStatus.CREATED)
  // public ResponseEntity<ResponseBody> update(
  // @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
  // @Valid @RequestBody LanguageExchangeCreateDTO exchangeData, BindingResult binding) {
  // ResponseEntity<ResponseBody> result;
  // // TODO revisar si el dto cumple con todas las restricciones
  // if (binding.hasErrors()) {
  // result = this.createResponse(exchangeData, binding);
  // } else {
  // try {
  // LanguageExchangeCreateDTO exchange = this.langExchangeMapper.entityToDtoCreate(
  // this.langExchangeService.save(this.langExchangeMapper.dtoCreateToEntity(exchangeData)));
  // result = this.createResponse(exchange);
  // } catch (Exception e) {
  // result = this.createMessageException(e);
  // }
  // }
  // return result;
  // }

  // @DeleteMapping("/{id}")
  // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  // @ResponseStatus(HttpStatus.NO_CONTENT)
  // public void delete(@PathVariable Integer id) {
  // LanguageExchange currentLangExchange = this.langExchangeService.findById(id);
  // this.langExchangeService.delete(currentLangExchange);
  // }

  @PostMapping("/{languageExchangeId}/join")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public ResponseEntity<ResponseBody> joinUser(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer languageExchangeId) {
    ResponseEntity<ResponseBody> result;

    try {
      LanguageExchangeDetailsDTO exchange = this.langExchangeMapper
          .entityToDto(this.langExchangeService.joinUser(principal, languageExchangeId));
      result = this.createResponse(exchange);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }

    return result;
  }

  @PostMapping("/{languageExchangeId}/leave")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public ResponseEntity<ResponseBody> leaveLanguageExchange(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer languageExchangeId) {
    ResponseEntity<ResponseBody> result;

    try {
      User user = this.userService.findByUsername(principal.getUsername());
      LanguageExchangeDetailsDTO exchange =
          this.langExchangeMapper.entityToDto(this.langExchangeService
              .leaveLanguageExchange(principal, user.getId(), languageExchangeId));
      result = this.createResponse(exchange);
    } catch (Exception e) {
      result = this.createResponse(e);
    }

    return result;
  }

  @PostMapping(consumes = "application/json")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ResponseBody> create(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @Valid @RequestBody LanguageExchangeCreateDTO langExchange, BindingResult binding) {
    ResponseEntity<ResponseBody> result;

    if (binding.hasErrors()) {
      result = this.createResponse(langExchange, binding);
    } else {
      try {
        LanguageExchangeDetailsDTO exchange = this.langExchangeMapper
            .entityToDto(this.langExchangeService.createAndSave(principal, langExchange));

        result = this.createResponse(exchange);
      } catch (Exception e) {
        result = this.createMessageException(e);
      }
    }
    return result;
  }

}
