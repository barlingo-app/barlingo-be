package com.barlingo.backend.models.services;

import java.util.List;
import com.barlingo.backend.models.entities.LanguageExchange;

public interface ILanguageExchangeService {

  List<LanguageExchange> findAll();

  LanguageExchange save(LanguageExchange exchange);

  LanguageExchange findById(Integer id);

  void delete(LanguageExchange exchange);

  LanguageExchange joinUser(Integer userId, Integer languageExchangeId);

  LanguageExchange leaveLanguageExchange(Integer userId, Integer languageExchangeId);

  List<LanguageExchange> findByEstId(Integer estId);

  LanguageExchange createAndSave(Integer creatorId, Integer establishmentId,
      LanguageExchange langExchange);

  List<LanguageExchange> findAllByUserId(Integer userId);

  List<LanguageExchange> findAllActual();
}
