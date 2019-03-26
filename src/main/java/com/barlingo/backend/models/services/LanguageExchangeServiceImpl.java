package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.repositories.LanguageExchangeRepository;
import com.barlingo.backend.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageExchangeServiceImpl implements ILanguageExchangeService {

	@Autowired
	private LanguageExchangeRepository langExchangeRepository;

	@Override
	public List<LanguageExchange> findAll() {
		return (List<LanguageExchange>) this.langExchangeRepository.findAll();
	}

	@Override
	public void save(LanguageExchange exchange) {
		this.langExchangeRepository.save(exchange);
	}

	@Override
	public LanguageExchange findById(Integer id) {
		return this.langExchangeRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(LanguageExchange exchange) {
		this.langExchangeRepository.delete(exchange);
	}
}
