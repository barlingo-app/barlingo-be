package com.barlingo.backend.models.dtos;
import java.util.Collection;
import javax.persistence.Tuple;

import lombok.Data;

@Data
public class EstablishmentDetailsDTO {

	private String establishmentName;
	private String description;
	private String address;
	private String imageProfile;
	private Collection<String> images;
	
	//TODO Find the way to note the tuple contains two Date objects
	private Collection<Collection<Tuple>> workingHours;

}
