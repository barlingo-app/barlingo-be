package com.barlingo.backend.models.services;

import java.util.List;
import com.barlingo.backend.models.entities.UserDiscount;

public interface IUserDiscountService {

  List<UserDiscount> findAll();

  UserDiscount createAndSave(Integer userId, Integer langExchangeId);

  UserDiscount findByCode(String code);

  UserDiscount findByLangExchangeId(Integer userId, Integer langExchangeId);

  UserDiscount save(UserDiscount userDiscount);

  Boolean isValid(UserDiscount userDiscount);

  UserDiscount redeem(UserDiscount userDiscount);

}
