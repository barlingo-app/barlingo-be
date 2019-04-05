package com.barlingo.backend.models.dtos;

import java.time.LocalDateTime;
import java.util.Collection;

import lombok.Data;

@Data
public class LanguageExchangeGenericDTO {

	private String title;
	private String description;
	private LocalDateTime moment;
	private Collection<String> targetLangs;
	private int numberOfParticipants;

}
