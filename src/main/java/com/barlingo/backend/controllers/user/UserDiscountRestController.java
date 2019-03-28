package com.barlingo.backend.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barlingo.backend.models.dtos.UserDiscountGenericDTO;
import com.barlingo.backend.models.mapper.UserDiscountMapper;
import com.barlingo.backend.models.services.UserDiscountServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/userDiscount/user")
public class UserDiscountRestController {

	@Autowired
	private UserDiscountServiceImpl userDiscountService;
	@Autowired
	private UserDiscountMapper userDiscountMapper;

	@PostMapping("/create/{languageExchangeId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAndSave(@PathVariable Integer languageExchangeId) {
		this.userDiscountService.createAndSave(languageExchangeId);
	}

	@GetMapping("/show/{languageExchangeId}")
	public UserDiscountGenericDTO show(@PathVariable Integer languageExchangeId) {
		return this.userDiscountMapper.entityToDto(this.userDiscountService.findByLangExchangeId(languageExchangeId));
	}

//	@GetMapping("/show/{code}")
//	public UserDiscountGenericDTO validateCode(@PathVariable String code) {
//		return this.userDiscountMapper.entityToDto(this.userDiscountService.findByCode(code));
//	}

}
