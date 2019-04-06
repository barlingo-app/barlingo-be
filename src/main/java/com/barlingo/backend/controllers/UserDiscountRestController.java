package com.barlingo.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.UserDiscountGenericDTO;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.mapper.UserDiscountMapper;
import com.barlingo.backend.models.services.IUserDiscountService;
import io.jsonwebtoken.lang.Assert;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/discounts")
public class UserDiscountRestController {

  @Autowired
  private IUserDiscountService userDiscountService;
  @Autowired
  private UserDiscountMapper userDiscountMapper;

  @GetMapping("")
  public List<UserDiscountGenericDTO> findDiscount(
      @RequestParam(value = "code", required = false) String code,
      @RequestParam(value = "langExchangeId", required = false) Integer langExchangeId,
      @RequestParam(value = "userId", required = false) Integer userId) {

    List<UserDiscount> discountList = new ArrayList<>();
    UserDiscount userDiscount, saved;

    if (code == null && langExchangeId == null && userId == null) {
      discountList = this.userDiscountService.findAll();
    } else {
      if (code != null) {
        userDiscount = this.userDiscountService.findByCode(code);
      } else {
        userDiscount = this.userDiscountService.findByLangExchangeId(userId, langExchangeId);
      }
      Assert.notNull(userDiscount, "code dont exist");
      discountList.add(userDiscount);
    }

    return this.userDiscountMapper.entitysToDtos(discountList);
  }

  @GetMapping("/validate")
  public UserDiscountGenericDTO validate(@RequestParam String code) {
    UserDiscount userDiscount;
    userDiscount = this.userDiscountService.findByCode(code);
    Assert.notNull(userDiscount, "code dont exist");
    Assert.isTrue(this.userDiscountService.isValid(userDiscount), "code is not valid");
    return this.userDiscountMapper.entityToDto(userDiscount);
  }


  @GetMapping("/redeem")
  public UserDiscountGenericDTO redeem(@RequestParam String code) {
    UserDiscount userDiscount, saved;
    userDiscount = this.userDiscountService.findByCode(code);
    Assert.notNull(userDiscount, "code dont exist");
    saved = this.userDiscountService.redeem(userDiscount);
    return this.userDiscountMapper.entityToDto(saved);
  }

}
