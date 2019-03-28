package com.barlingo.backend.models.dtos;

import com.barlingo.backend.models.entities.Language;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class ParticipantDTO {

	private String name;
	private String surname;
	private String country;
	private String city;
	private String personalPic;
	private String profileBackPic;
}
