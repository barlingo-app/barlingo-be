package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.ExchangeState;

public interface IExchangeStateService {

	ExchangeState findById(Integer id);
	
}
