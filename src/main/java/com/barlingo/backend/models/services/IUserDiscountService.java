package com.barlingo.backend.models.services;

import java.util.List;
import com.barlingo.backend.models.entities.UserDiscount;

public interface IUserDiscountService {

  List<UserDiscount> findAll();

  UserDiscount createAndSave(Integer userId, Integer langExchangeId);

  UserDiscount findByCode(String code);

  UserDiscount findByLangExchangeId(org.springframework.security.core.userdetails.User principal,
      Integer userId, Integer langExchangeId) throws Exception;

  UserDiscount save(UserDiscount userDiscount);

  Boolean isValid(org.springframework.security.core.userdetails.User principal,
      UserDiscount userDiscount);

  UserDiscount redeem(org.springframework.security.core.userdetails.User principal,
      UserDiscount userDiscount);

}
