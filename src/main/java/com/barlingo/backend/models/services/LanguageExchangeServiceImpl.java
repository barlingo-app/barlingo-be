package com.barlingo.backend.models.services;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.repositories.LanguageExchangeRepository;

@Service
@Transactional
public class LanguageExchangeServiceImpl implements ILanguageExchangeService {

	@Autowired
	private LanguageExchangeRepository langExchangeRepository;
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserDiscountService userDiscountService;

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
	public LanguageExchange joinUser(Integer languageExchangeId) {
		LanguageExchange langExchangeSaved;
		LanguageExchange langExchange = this.findById(languageExchangeId);
		Assert.notNull(langExchange, "Invalid language exchange");
		// Si el evento ha tenido lugar en más de un día salta excepción
//		Assert.isTrue(langExchange.getMoment().toInstant().plusSeconds(86400).isAfter(Instant.now()), "Event has already taken place");
		// TODO
//		User user = this.userService.findByPrincipal();
		User user = this.userService.findById(11);

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
			this.userDiscountService.createAndSave(languageExchangeId);
		}
		langExchangeSaved = this.save(langExchange);

		return langExchangeSaved;
	}

	@Override
	public List<LanguageExchange> findByEstId(Integer estId) {
		return (List<LanguageExchange>) this.langExchangeRepository.findByEstId(estId);
	}
}
