package com.barlingo.backend.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barlingo.backend.models.entities.ExchangeState;
import com.barlingo.backend.models.repositories.ExchangeStateRepository;

@Service
@Transactional
public class ExchangeStateService implements IExchangeStateService {

	
	@Autowired
	private ExchangeStateRepository exchangeStateRepository;
	
	@Override
	public ExchangeState findById(Integer id) {
		return this.exchangeStateRepository.findById(id).orElse(null);
	}

}
