package com.barlingo.backend.models.dtos;
import java.time.LocalTime;
import java.util.Collection;
import lombok.Data;
import org.javatuples.Pair;

@Data
public class EstablishmentDetailsDTO {

	private String establishmentName;
	private String description;
	private String address;
	private String imageProfile;
	private Collection<String> images;
	
	private Collection<Pair<LocalTime, LocalTime>> workingHours;

}
