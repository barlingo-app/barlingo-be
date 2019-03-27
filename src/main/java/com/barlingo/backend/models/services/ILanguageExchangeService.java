package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.LanguageExchange;

import java.util.List;

public interface ILanguageExchangeService {

	List<LanguageExchange> findAll();

	void save(LanguageExchange exchange);

	LanguageExchange findById(Integer id);

	void delete(LanguageExchange exchange);
}
