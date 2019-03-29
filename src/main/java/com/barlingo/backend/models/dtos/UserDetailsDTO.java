package com.barlingo.backend.models.dtos;

import java.util.Collection;
import java.util.Date;


import com.barlingo.backend.models.entities.Language;

import lombok.Data;

@Data
public class UserDetailsDTO {

	private String name;
	private String surname;
	private Date birthdate;
	private String country;
	private String city;
	private String personalPic;
	private String profileBackPic;
	private String aboutMe;
	private Collection<Language> speakLanguages;
	private Collection<Language> learnLanguages;

}
