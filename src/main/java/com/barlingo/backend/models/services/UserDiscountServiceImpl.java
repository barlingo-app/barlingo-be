package com.barlingo.backend.models.services;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.barlingo.backend.models.entities.Actor;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.repositories.UserDiscountRepository;

@Service
@Transactional
public class UserDiscountServiceImpl implements IUserDiscountService {

	private static final String USER_NOT_NULL_IN_CREATE_USER_DISCOUNT = "User not null in create UserDiscount";
	@Autowired
	private UserDiscountRepository userDiscountRepository;
	@Autowired
	private ActorService actorService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ILanguageExchangeService languageExchangeService;

	@Override
	public UserDiscount createAndSave(Integer langExchangeId) {
		UserDiscount udSaved;

		// TODO: Catch principal
//		User user = this.userService.findByPrincipal();
		User user = this.userService.findById(11);
		Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);

		UserDiscount userDiscount = new UserDiscount();
		userDiscount.setCode(this.generateUniqueCode());
		userDiscount.setIsVisible(false);
		userDiscount.setExchanged(false);
//		userDiscount.setLangExchange(this.languageExchangeService.findById(langExchangeId));
		userDiscount.setUser(user);

		udSaved = this.userDiscountRepository.save(userDiscount);
		return udSaved;
	}

	@Override
	public UserDiscount findByCode(String code) {
		// TODO: Catch principal
//		User user = this.userService.findByPrincipal();
		User user = this.userService.findById(1);
		Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);

		return this.userDiscountRepository.findByCode(code);
	}

	@Override
	public UserDiscount findByLangExchangeId(Integer langExchangeId) {
		// TODO: Catch principal
//		User user = this.userService.findByPrincipal();
//		Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);
//		Assert.isTrue(this.userService.findById(1).getLangsExchange().contains(
//				this.languageExchangeService.findById(langExchangeId)), USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);

		UserDiscount ud = this.userDiscountRepository.findByLangExchangeId(langExchangeId);
		LanguageExchange langExchange = this.languageExchangeService.findById(langExchangeId);

		// Restrictions dates
		Assert.isTrue(ud.getIsVisible(), "User discount not enable yet");
		// Refresh isVisible
		if (langExchange.getMoment().toInstant().isBefore(Instant.now())) {
			ud.setIsVisible(true);
			this.userDiscountRepository.save(ud);
		}
		// TODO: confirmar que el intercambio no ha sido canjeado ya.
		Assert.isTrue(!ud.getExchanged(), "User discount alredy exchaged");

		return ud;
	}

	///////////////////////
	// Auxiliary Methods //
	///////////////////////

	public void checkPrincipal(final UserDiscount userDiscount) {
		final Actor principal = this.actorService.findByPrincipal();
		User userPrincipal = null;
		if (principal instanceof User) {
			userPrincipal = (User) principal;
			Assert.isTrue(userDiscount.getUser().equals(userPrincipal), "");
		} else {
			Assert.isTrue(Boolean.TRUE, "Usuario no válido.");
		}
	}

	/**
	 * Generate an unique reference
	 *
	 * @return the reference
	 * @throws NoSuchAlgorithmException
	 */
	private String generateUniqueCode() {
		final SimpleDateFormat dt = new SimpleDateFormat("ddMMyyyy");
		final Random r = new Random();
		StringBuilder randomLetter = new StringBuilder();
		String reference = "";

		while (this.checkReference(reference) || reference.equals("")) {
			for (int i = 0; i < 2; i++)
				randomLetter.append(String.valueOf((char) (r.nextInt(26) + 'A')));

			reference = dt.format(new Date()) + "-" + randomLetter;
		}
		return reference;
	}

	/**
	 * Check if exist a coincidence
	 *
	 * @param reference
	 * @return
	 */
	private boolean checkReference(final String reference) {
		Boolean result = false;
		if (this.userDiscountRepository.findByCode(reference) != null)
			result = true;
		return result;
	}
}
