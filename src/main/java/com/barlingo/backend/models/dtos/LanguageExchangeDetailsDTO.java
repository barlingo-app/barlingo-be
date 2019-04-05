package com.barlingo.backend.models.dtos;

import java.time.LocalDateTime;
import java.util.Collection;

import com.barlingo.backend.models.entities.ExchangeState;

import lombok.Data;

@Data
public class LanguageExchangeDetailsDTO {

	private Integer id;
	private String title;
	private String description;
	private LocalDateTime moment;
	private UserDetailsDTO creator;
	private EstablishmentDetailsDTO establishment;
	private ExchangeState exchangeState;
	private Collection<String> targetLangs;
	private Collection<ParticipantDTO> participants;

}
