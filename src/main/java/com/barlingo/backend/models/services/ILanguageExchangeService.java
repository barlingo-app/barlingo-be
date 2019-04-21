package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.List;
import com.barlingo.backend.models.dtos.LanguageExchangeCreateDTO;
import com.barlingo.backend.models.entities.LanguageExchange;

public interface ILanguageExchangeService {

  List<LanguageExchange> findAll(LocalDateTime moment);

  LanguageExchange save(LanguageExchange exchange);

  LanguageExchange findById(Integer id);

  void delete(LanguageExchange exchange);

  LanguageExchange joinUser(org.springframework.security.core.userdetails.User principal,
      Integer languageExchangeId);

  LanguageExchange leaveLanguageExchange(
      org.springframework.security.core.userdetails.User principal, Integer userId,
      Integer languageExchangeId);

  /**
   * Find all language exchanges witch took place in a establishment
   * 
   * @param estId the id of the establishment to be filter with
   * @param moment to fetch exchanges after the given date, if null fetch all
   * @return the list of exchanges
   */
  List<LanguageExchange> findByEstId(Integer estId, LocalDateTime moment);

  LanguageExchange createAndSave(org.springframework.security.core.userdetails.User principal,
      LanguageExchangeCreateDTO langExchange);

  /**
   * Find all language exchanges of an user
   * 
   * @param userId the id of the exchange user to be filter with
   * @param moment to fetch exchanges after the given date, if null fetch all
   * @return the list of exchanges
   */
  List<LanguageExchange> findAllByUserId(Integer userId, LocalDateTime moment);
}
