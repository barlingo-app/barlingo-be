package com.barlingo.backend.models.dtos;

import java.util.Collection;

import org.javatuples.Pair;

import lombok.Data;

@Data
public class EstablishmentGenericDTO {
	
	private String establishmentName;
	private String address;
	private String imageProfile;
	//private Collection<Pair<String, String>> workingHours;

}
