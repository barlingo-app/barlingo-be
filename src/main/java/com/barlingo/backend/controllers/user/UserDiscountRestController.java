package com.barlingo.backend.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.dtos.UserDiscountGenericDTO;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.mapper.UserDiscountMapper;
import com.barlingo.backend.models.services.IUserDiscountService;

import io.jsonwebtoken.lang.Assert;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/userDiscount/user")
public class UserDiscountRestController {

	@Autowired
	private IUserDiscountService userDiscountService;
	@Autowired
	private UserDiscountMapper userDiscountMapper;

//	@PostMapping("/create/{languageExchangeId}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public void createAndSave(@RequestParam Integer userId, @PathVariable Integer languageExchangeId) {
//		this.userDiscountService.createAndSave(userId, languageExchangeId);
//	}

	@GetMapping("/show/{langExchangeId}")
	public UserDiscountGenericDTO show(@RequestParam Integer userId, @PathVariable Integer langExchangeId) {
		return this.userDiscountMapper
				.entityToDto(this.userDiscountService.findByLangExchangeId(userId, langExchangeId));
	}
	
	@GetMapping("/validate/{code}")
	public UserDiscountGenericDTO validate(@PathVariable String code ) {
		UserDiscount userDiscount,saved;
		userDiscount = this.userDiscountService.findByCode(code);
		Assert.notNull(userDiscount,"code dont exist");
		saved = this.userDiscountService.validate(userDiscount);
		return this.userDiscountMapper.entityToDto(saved);
	}

//	@GetMapping("/show/{code}")
//	public UserDiscountGenericDTO validateCode(@PathVariable String code) {
//		return this.userDiscountMapper.entityToDto(this.userDiscountService.findByCode(code));
//	}

}
