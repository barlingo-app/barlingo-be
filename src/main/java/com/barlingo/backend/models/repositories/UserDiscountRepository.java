package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.UserDiscount;

public interface UserDiscountRepository extends JpaRepository<UserDiscount, Integer> {
	
	UserDiscount findByCode(String code);

	UserDiscount findByUserIdAndLangExchangeId(Integer userId, Integer langExchangeId);
}
