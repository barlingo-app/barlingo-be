package com.barlingo.backend.models.dtos;

import java.util.Collection;
import java.util.Date;

import com.barlingo.backend.models.entities.ExchangeState;
import com.barlingo.backend.models.entities.Language;

import lombok.Data;

@Data
public class LanguageExchangeDetailsDTO {
	
	private Integer id;
	private String title;
	private String description;
	private Date moment;
	private UserDetailsDTO creator;
	private EstablishmentDetailsDTO establishment;
	private ExchangeState exchangeState;
	private Collection<Language> targetLangs;
	private Collection<ParticipantDTO> participants;

}
