package com.barlingo.backend.models.dtos;

import java.util.Collection;
import java.util.Date;

import com.barlingo.backend.models.entities.Language;

import lombok.Data;


@Data
public class LanguageExchangeGenericDTO {
	
	private String title;
	private String description;
	private Date moment;
	private Collection<Language> targetLangs;
	private int numberOfParticipants;

	
}
