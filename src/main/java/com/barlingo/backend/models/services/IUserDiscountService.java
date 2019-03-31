package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.UserDiscount;

public interface IUserDiscountService {

	UserDiscount createAndSave(Integer userId, Integer langExchangeId);

	UserDiscount findByCode(String code);

	UserDiscount findByLangExchangeId(Integer userId, Integer langExchangeId);
	
	UserDiscount save(UserDiscount userDiscount);
	
	UserDiscount validate(UserDiscount userDiscount);
	
}
