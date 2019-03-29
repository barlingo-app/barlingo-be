package com.barlingo.backend.models.dtos;

import java.util.Collection;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.ExchangeState;
import com.barlingo.backend.models.entities.Language;
import com.barlingo.backend.models.entities.User;

import lombok.Data;


@Data
public class LanguageExchangeGenericDTO {
	
	private String title;
	private String description;
	private Date moment;
	private Collection<Language> targetLangs;
	private int numberOfParticipants;

	
}
