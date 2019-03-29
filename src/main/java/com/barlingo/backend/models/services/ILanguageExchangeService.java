package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.LanguageExchange;

import java.util.Collection;
import java.util.List;

public interface ILanguageExchangeService {

	List<LanguageExchange> findAll();

	LanguageExchange save(LanguageExchange exchange);

	LanguageExchange findById(Integer id);

	void delete(LanguageExchange exchange);

	LanguageExchange joinUser(Integer languageExchangeId);
	
	List<LanguageExchange> findByEstId(Integer estId);
}
