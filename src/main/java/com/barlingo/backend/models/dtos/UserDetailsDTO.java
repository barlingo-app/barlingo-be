package com.barlingo.backend.models.dtos;

import java.time.LocalDateTime;
import java.util.Collection;

import com.barlingo.backend.models.entities.Language;

import lombok.Data;

@Data
public class UserDetailsDTO {

	private Integer id;
	private String name;
	private String surname;
	private LocalDateTime birthdate;
	private String country;
	private String city;
	private String personalPic;
	private String profileBackPic;
	private String aboutMe;
	private Collection<Language> speakLanguages;
	private Collection<Language> learnLanguages;

}
