package com.barlingo.backend.models.entities;

import java.time.LocalTime;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import org.javatuples.Pair;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class Establishment extends Actor {

	////////////////
	// Attributes //
	////////////////
	@NotBlank
	@SafeHtml
	private String establishmentName;

	@SafeHtml
	private String description;

	@NotBlank
	@SafeHtml
	private String address;
	
	@URL
	@ElementCollection
	private Collection<String> images;

	@URL
	@NotBlank
	@SafeHtml
	private String imageProfile;

	@ElementCollection
	private Collection<Pair<String, String>> workingHours;
	
	///////////////
	// Relations //
	///////////////
	@OneToOne
	private SubscriptionData subscription;
}
