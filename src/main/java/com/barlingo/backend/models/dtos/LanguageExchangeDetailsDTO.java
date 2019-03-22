package com.barlingo.backend.models.dtos;

import java.util.Collection;
import java.util.Date;

import com.barlingo.backend.models.entities.Language;
import com.barlingo.backend.models.entities.User;

import lombok.Data;

@Data
public class LanguageExchangeDetailsDTO {
	
	private String title;
	private String description;
	private Date moment;
	private Collection<Language> targetLanguages;
	private Collection<User> participants;

}
