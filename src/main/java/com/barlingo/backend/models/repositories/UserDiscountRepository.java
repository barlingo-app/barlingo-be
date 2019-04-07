package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.UserDiscount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDiscountRepository extends JpaRepository<UserDiscount, Integer> {

  List<UserDiscount> findAll();

  UserDiscount findByCode(String code);

  UserDiscount findByUserIdAndLangExchangeId(Integer userId, Integer langExchangeId);
}
