package com.barlingo.backend.models.services;

import java.time.Instant;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.ExchangeState;
import com.barlingo.backend.models.entities.Language;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.entities.UserDiscount;
import com.barlingo.backend.models.repositories.LanguageExchangeRepository;

@Service
@Transactional
public class LanguageExchangeServiceImpl implements ILanguageExchangeService {

	
	private static final String USER_NOT_NULL_IN_CREATE_USER_DISCOUNT = "User not null in create UserDiscount";
	private static final String LANGEXCHANGE_NOT_NULL_IN_CREATE_USER_DISCOUNT = "language Exchange can not be null";
	@Autowired
	private LanguageExchangeRepository langExchangeRepository;
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserDiscountService userDiscountService;
	@Autowired
	private IExchangeStateService exchangeStateService;
	@Autowired
	private IEstablishmentService establishmentService;
	
	
	@Override
	public LanguageExchange createAndSave(int creatorId, int exchangeStateId, int establishmentId, LanguageExchange langExchange) {
		Assert.notNull(langExchange, LANGEXCHANGE_NOT_NULL_IN_CREATE_USER_DISCOUNT);
		User user = this.userService.findById(creatorId);
		Assert.notNull(user, USER_NOT_NULL_IN_CREATE_USER_DISCOUNT);
		LanguageExchange langExch = new LanguageExchange();
		langExch.setCreator(user);
		langExch.setTitle(langExchange.getTitle());
		langExch.setDescription(langExchange.getDescription());
		langExch.setMoment(langExchange.getMoment());
		Collection<User> participants = new LinkedList<User>();
		participants.add(user);
		langExch.setParticipants(participants);
		ExchangeState open = new ExchangeState();
		open = this.exchangeStateService.findById(exchangeStateId);
		langExch.setExchangeState(open);
		Establishment establish = new Establishment();
		establish = this.establishmentService.findById(establishmentId);
		langExch.setEstablishment(establish);
		Collection<UserDiscount> userDiscounts = new LinkedList<UserDiscount>();
		Collection<Language> targetLangs = new LinkedList<Language>();
		
		langExch.setTargetLangs(targetLangs);
		langExch.setUserDiscounts(userDiscounts);
		
		
		LanguageExchange saved = this.langExchangeRepository.save(langExch);
		
		return saved;
	}

	@Override
	public List<LanguageExchange> findAll() {
		return this.langExchangeRepository.findAll();
	}

	@Override
	public LanguageExchange save(LanguageExchange exchange) {
		return this.langExchangeRepository.save(exchange);
	}

	@Override
	public LanguageExchange findById(Integer id) {
		return this.langExchangeRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(LanguageExchange exchange) {
		this.langExchangeRepository.delete(exchange);
	}

	@Override
	public LanguageExchange joinUser(Integer userId, Integer languageExchangeId) {
		LanguageExchange langExchangeSaved;
		LanguageExchange langExchange = this.findById(languageExchangeId);
		Assert.notNull(langExchange, "Invalid language exchange");
		// Si el evento ha tenido lugar en más de un día salta excepción
		Assert.isTrue(langExchange.getMoment().toInstant().isBefore(Instant.now()), "Event has already taken place");
		// TODO
//		User user = this.userService.findByPrincipal();
		User user = this.userService.findById(userId);

		if (langExchange.getMoment().toInstant().isBefore(Instant.now())) {
			Collection<LanguageExchange> userExchanges = user.getLangsExchanges();
			Assert.isTrue(!user.getLangsExchanges().contains(langExchange), "You already register");

			userExchanges.add(langExchange);
			user.setLangsExchanges(userExchanges);

			Collection<User> participants = langExchange.getParticipants();
			Assert.isTrue(!langExchange.getParticipants().contains(user), "You already register");

			participants.add(this.userService.save(user));
			langExchange.setParticipants(participants);

			// Generate new code to new participant
			this.userDiscountService.createAndSave(userId, languageExchangeId);
		}
		langExchangeSaved = this.save(langExchange);

		return langExchangeSaved;
	}

	@Override
	public List<LanguageExchange> findByEstId(Integer estId) {
		return (List<LanguageExchange>) this.langExchangeRepository.findByEstId(estId);
	}
}
