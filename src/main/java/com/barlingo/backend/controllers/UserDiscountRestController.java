package com.barlingo.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.UserDiscountGenericDTO;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.mapper.UserDiscountMapper;
import com.barlingo.backend.models.services.IEstablishmentService;
import com.barlingo.backend.models.services.IUserDiscountService;
import io.jsonwebtoken.lang.Assert;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/discounts")
public class UserDiscountRestController {

  @Autowired
  private IUserDiscountService userDiscountService;
  @Autowired
  private IEstablishmentService establishmentService;
  @Autowired
  private UserDiscountMapper userDiscountMapper;


  @GetMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTABLISHMENT')")
  public List<UserDiscountGenericDTO> findDiscount(
      @RequestParam(value = "code", required = false) String code,
      @RequestParam(value = "langExchangeId", required = false) Integer langExchangeId,
      @RequestParam(value = "validate", required = false, defaultValue = "false") Boolean validate,
      @RequestParam(value = "userId", required = false) Integer userId,
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {

    List<UserDiscount> discountList = new ArrayList<>();
    UserDiscount userDiscount;
    Establishment current;

    if (code == null && langExchangeId == null && userId == null) {
      discountList = this.userDiscountService.findAll();
    } else {
      if (code != null) {
        current = this.establishmentService.findByUsername(principal.getUsername());
        Assert.notNull(current, "error getting current establishment");
        userDiscount = this.userDiscountService.findByCode(code);
        Assert.notNull(userDiscount, "code dont exists");
        Assert.isTrue(userDiscount.getLangExchange().getEstablishment().equals(current),
            "cannot redeem discounts from other establishments");

        if (validate.equals(true)) {
          current = this.establishmentService.findByUsername(principal.getUsername());
          Assert.isTrue(userDiscount.getLangExchange().getEstablishment().equals(current),
              "cannot validate discounts from other establishments");
          Assert.isTrue(this.userDiscountService.isValid(userDiscount), "code is not valid");
        }
      } else {
        userDiscount = this.userDiscountService.findByLangExchangeId(userId, langExchangeId);
      }
      Assert.notNull(userDiscount, "code dont exists");
      discountList.add(userDiscount);
    }

    return this.userDiscountMapper.entitysToDtos(discountList);
  }

  @PutMapping("/{code}/redeem")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public UserDiscountGenericDTO redeem(@PathVariable("code") String code,
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {
    UserDiscount userDiscount;
    UserDiscount saved;
    Establishment current;

    current = this.establishmentService.findByUsername(principal.getUsername());
    Assert.notNull(current, "error getting current establishment");
    userDiscount = this.userDiscountService.findByCode(code);
    Assert.notNull(userDiscount, "code dont exists");
    Assert.isTrue(userDiscount.getLangExchange().getEstablishment().equals(current),
        "cannot redeem discounts from other establishments");
    saved = this.userDiscountService.redeem(userDiscount);
    return this.userDiscountMapper.entityToDto(saved);
  }

}
