package com.barlingo.backend.models.services;

import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.barlingo.backend.models.entities.LanguageExchange;

public interface ILanguageExchangeService {

  List<LanguageExchange> findAll();

  LanguageExchange save(LanguageExchange exchange);

  LanguageExchange findById(Integer id);

  void delete(LanguageExchange exchange);

  LanguageExchange joinUser(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      Integer userId, Integer languageExchangeId);

  LanguageExchange leaveLanguageExchange(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      Integer userId, Integer languageExchangeId);

  List<LanguageExchange> findByEstId(Integer estId);

  LanguageExchange createAndSave(Integer creatorId, Integer establishmentId,
      LanguageExchange langExchange);

  List<LanguageExchange> findAllByUserId(Integer userId);

  List<LanguageExchange> findAllActual();
}
