package com.barlingo.backend.models.dtos;

import lombok.Data;
import org.javatuples.Pair;

import java.time.LocalTime;
import java.util.Collection;

@Data
public class EstablishmentGenericDTO {
	
	private String establishmentName;
	private String address;
	private String imageProfile;
	private String workingHours;

}
