package com.barlingo.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.mapper.UserDiscountMapper;
import com.barlingo.backend.models.services.IEstablishmentService;
import com.barlingo.backend.models.services.IUserDiscountService;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.RestError;
import io.jsonwebtoken.lang.Assert;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/discounts")
public class UserDiscountRestController extends AbstractRestController {

  @Autowired
  private IUserDiscountService userDiscountService;
  @Autowired
  private IEstablishmentService establishmentService;
  @Autowired
  private UserDiscountMapper userDiscountMapper;


  @GetMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> findDiscount(
      @RequestParam(value = "code", required = false) String code,
      @RequestParam(value = "langExchangeId", required = false) Integer langExchangeId,
      @RequestParam(value = "validate", required = false, defaultValue = "false") Boolean validate,
      @RequestParam(value = "userId", required = false) Integer userId,
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {
    ResponseEntity<ResponseBody> result;
    List<UserDiscount> discountList = new ArrayList<>();
    UserDiscount userDiscount;
    Establishment current;
    try {
      if (code == null && langExchangeId == null && userId == null) {
        discountList = this.userDiscountService.findAll();
      } else {
        if (code != null) {
          userDiscount = this.userDiscountService.findByCode(code);

          if (validate.equals(true)) {
            current = this.establishmentService.findByUsername(principal.getUsername());
            Assert.isTrue(userDiscount.getLangExchange().getEstablishment().equals(current),
                RestError.SIGNED_USERDISCOUNT_CODE_BELONG_OTHER_ESTABLISHMENT);
            Assert.isTrue(this.userDiscountService.isValid(userDiscount),
                RestError.SIGNED_USERDISCOUNT_CODE_NOT_VALID);
          }
        } else {
          userDiscount = this.userDiscountService.findByLangExchangeId(userId, langExchangeId);
        }
        Assert.notNull(userDiscount, RestError.SIGNED_USERDISCOUNT_CODE_NOT_EXISTS);
        discountList.add(userDiscount);
      }
      result = this.createResponse(this.userDiscountMapper.entitysToDtos(discountList));
    } catch (Exception e) {
      result = this.createMessageException(e);
    }

    return result;
  }

  @PutMapping("/{code}/redeem")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> redeem(@PathVariable("code") String code,
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {
    ResponseEntity<ResponseBody> result;
    UserDiscount userDiscount;
    UserDiscount saved;
    Establishment current;
    try {
      current = this.establishmentService.findByUsername(principal.getUsername());
      Assert.notNull(current, RestError.ESTABLISHMENT_ESTABLISHMENT_NOT_FOUND);
      userDiscount = this.userDiscountService.findByCode(code);
      Assert.notNull(userDiscount, RestError.SIGNED_USERDISCOUNT_CODE_NOT_EXISTS);
      Assert.isTrue(userDiscount.getLangExchange().getEstablishment().equals(current),
          RestError.SIGNED_USERDISCOUNT_CODE_BELONG_OTHER_ESTABLISHMENT);
      saved = this.userDiscountService.redeem(userDiscount);

      result = this.createResponse(this.userDiscountMapper.entityToDto(saved));
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }
}
