package com.barlingo.backend.models.dtos;

import java.util.Collection;

import com.barlingo.backend.models.entities.Language;

import lombok.Data;

@Data
public class UserGenericDTO {
	
	private String name;
	private String surname;
	private String personalPic;
	private Collection<Language> speakLanguages;
	private Collection<Language> learnLanguages;

}
