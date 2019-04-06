package com.barlingo.backend.models.dtos;

import java.time.LocalDateTime;
import java.util.Collection;

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
	private Collection<String> speakLangs;
	private Collection<String> langsToLearn;

}
