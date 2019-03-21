package com.barlingo.backend.models.dtos;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import com.barlingo.backend.models.entities.Language;

import lombok.Data;

@Entity
@Data
@Access(AccessType.PROPERTY)
public class LanguageExchangeGenericDTO {
	
	private String title;
	private String description;
	private Date moment;
	private Collection<Language> targetLanguages;
	
	private int numberOfParticipants;
	//Collection with the URLs of the participants profile picture
	private Collection<String> participants;
	
}
