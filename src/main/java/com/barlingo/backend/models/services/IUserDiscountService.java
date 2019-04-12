package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.UserDiscount;
import java.util.List;

public interface IUserDiscountService {

  List<UserDiscount> findAll();

  UserDiscount createAndSave(Integer userId, Integer langExchangeId);

  UserDiscount findByCode(String code);

  UserDiscount findByLangExchangeId(Integer userId, Integer langExchangeId);

  UserDiscount save(UserDiscount userDiscount);

  Boolean isValid(UserDiscount userDiscount);

  UserDiscount redeem(UserDiscount userDiscount);

}
