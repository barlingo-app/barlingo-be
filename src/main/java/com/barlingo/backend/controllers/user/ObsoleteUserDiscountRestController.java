package com.barlingo.backend.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.mapper.UserDiscountMapper;
import com.barlingo.backend.models.services.IUserDiscountService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/userDiscount/user")
public class ObsoleteUserDiscountRestController {

  @Autowired
  private IUserDiscountService userDiscountService;
  @Autowired
  private UserDiscountMapper userDiscountMapper;

  // @PostMapping("/create/{languageExchangeId}")
  // @ResponseStatus(HttpStatus.CREATED)
  // public void createAndSave(@RequestParam Integer userId, @PathVariable Integer
  // languageExchangeId) {
  // this.userDiscountService.createAndSave(userId, languageExchangeId);
  // }

  /*
   * @GetMapping("/show/{langExchangeId}") public UserDiscountGenericDTO
   * show(@AuthenticationPrincipal org.springframework.security.core.userdetails.User
   * principal,@RequestParam Integer userId,
   * 
   * @PathVariable Integer langExchangeId) { return this.userDiscountMapper
   * .entityToDto(this.userDiscountService.findByLangExchangeId(principal, userId, langExchangeId));
   * }
   */

  /*
   * @GetMapping("/validate/{code}") public UserDiscountGenericDTO validate(@PathVariable String
   * code) { UserDiscount userDiscount; userDiscount = this.userDiscountService.findByCode(code);
   * Assert.notNull(userDiscount, "code dont exist");
   * Assert.isTrue(this.userDiscountService.isValid(userDiscount), "code is not valid"); return
   * this.userDiscountMapper.entityToDto(userDiscount); }
   *
   * @GetMapping("/redeem/{code}") public UserDiscount redeem(@PathVariable String code) {
   * UserDiscount userDiscount, saved; userDiscount = this.userDiscountService.findByCode(code);
   * Assert.notNull(userDiscount, "code dont exist"); saved =
   * this.userDiscountService.redeem(userDiscount); return saved; }
   */

  // @GetMapping("/show/{code}")
  // public UserDiscountGenericDTO validateCode(@PathVariable String code) {
  // return this.userDiscountMapper.entityToDto(this.userDiscountService.findByCode(code));
  // }

}
