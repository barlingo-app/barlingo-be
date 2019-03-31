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
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.repositories.UserDiscountRepository;

@Service
@Transactional
public class UserDiscountServiceImpl implements IUserDiscountService {

	private static final String USER_NOT_NULL_IN_CREATE_USER_DISCOUNT = "User not null in create UserDiscount";
	private static final String USER_NOT_JOINT_IN_USER_DISCOUNT = "User not joint to the exchange in user discount";
	@Autowired
	private UserDiscountRepository userDiscountRepository;
	@Autowired
	private ActorService actorService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ILanguageExchangeService languageExchangeService;

	@Override
	public UserDiscount createAndSave(Integer userId, Integer langExchangeId) {
		UserDiscount udSaved;

		// TODO: Catch principal
		//		User user = this.userService.findByPrincipal();
		User user = this.userService.findById(userId);
		Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);

		UserDiscount userDiscount = new UserDiscount();
		userDiscount.setCode(this.generateUniqueCode());
		userDiscount.setIsVisible(false);
		userDiscount.setExchanged(false);
		userDiscount.setLangExchange(this.languageExchangeService.findById(langExchangeId));
		userDiscount.setUser(user);

		udSaved = this.userDiscountRepository.save(userDiscount);
		return udSaved;
	}

	/**
	 * Update an existing UserDiscount
	 * @param userDiscount
	 * @return saved
	 */
	@Override
	public UserDiscount save(UserDiscount userDiscount) {
		UserDiscount saved;
		Assert.notNull(userDiscount,"userDiscount cannot be null");
		Assert.notNull(userDiscount.getUser(),"user cannot be null");
		Assert.notNull(userDiscount.getLangExchange(),"language exchange cannot be null");

		/*Comprueba que exista el usuario y el intercambio*/
		Assert.isTrue(this.userService.findById(userDiscount.getUser().getId()) != null,"discount user doesnt exist");
		Assert.isTrue(this.languageExchangeService.findById(userDiscount.getLangExchange().getId()) != null,"discount exchange doesnt exist");
		/*Comprueba que el usuario del descuento se haya unido al intercambio del descuento*/
		//Assert.isTrue(userDiscount.getLangExchange().getParticipants().stream().anyMatch(p -> p.getId() == userDiscount.getUser().getId()),
		//		USER_NOT_JOINT_IN_USER_DISCOUNT);
		/*Comprueba que el mismo código no pertenezca ya a otro UserDiscount*/
		UserDiscount duplicate = this.findByCode(userDiscount.getCode());
		if(duplicate != null && userDiscount.getId() > 0)
			Assert.isTrue(userDiscount.getId() == duplicate.getId(),"this code belongs to another exchange");


		saved = this.userDiscountRepository.save(userDiscount);
		Assert.notNull(saved, "error saving the discount in repository");
		return saved;
	}

	@Override
	public UserDiscount findByCode(String code) {
		// TODO: Catch principal
		//		User user = this.userService.findByPrincipal();
		//User user = this.userService.findById(1);
		//Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);

		return this.userDiscountRepository.findByCode(code);
	}

	@Override
	public UserDiscount findByLangExchangeId(Integer userId, Integer langExchangeId) {
		UserDiscount udSaved = null;
		// TODO: Catch principal
		//		User user = this.userService.findByPrincipal();
		User user = this.userService.findById(userId);
		Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);
		//		Assert.isTrue(this.userService.findById(1).getLangsExchange().contains(
		//				this.languageExchangeService.findById(langExchangeId)), USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);

		UserDiscount ud = this.userDiscountRepository.findByUserIdAndLangExchangeId(userId, langExchangeId);
		// Refresh isVisible 4hours before that languageExchange
		if (ud.getLangExchange().getMoment().toInstant().minusSeconds(14400).isBefore(Instant.now()) &&
				ud.getLangExchange().getMoment().toInstant().plusSeconds(86400).isAfter(Instant.now())) {
			ud.setIsVisible(true);
			udSaved = this.userDiscountRepository.save(ud);
		} else if(ud.getIsVisible()){
			ud.setIsVisible(false);
			udSaved = this.userDiscountRepository.save(ud);
		}

		// TODO: confirmar que el intercambio no ha sido canjeado ya.
		// Restrictions
		Assert.isTrue(ud.getIsVisible(), "User discount not enable yet");
		Assert.isTrue(!ud.getExchanged(), "User discount already exchaged");

		return udSaved;
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
			for (int i = 0; i < 4; i++)
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

	@Override
	public UserDiscount validate(UserDiscount userDiscount) {
		UserDiscount saved;
		//TODO: Checks current establishment can validate code

		Assert.isTrue(!userDiscount.getExchanged(),"discount already exchanged");
		Assert.isTrue(userDiscount.getIsVisible(),"discount code is not visible yet");
		
		//Check code has not expired
		Assert.isTrue(
				userDiscount.getLangExchange().getMoment().toInstant().plusSeconds(86400).isBefore(Instant.now())
				,"discount code has expired");
			userDiscount.setExchanged(true);
			saved = this.save(userDiscount);
			Assert.notNull(saved,"error updating users discount in database");
		
			
		return saved;
	}


}
