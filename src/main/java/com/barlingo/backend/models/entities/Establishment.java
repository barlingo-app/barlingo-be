package com.barlingo.backend.models.entities;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;

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

	@NotBlank
	@SafeHtml
	private String workingHours;
	
	///////////////
	// Relations //
	///////////////
	@OneToOne
	private SubscriptionData subscription;

	@OneToMany(mappedBy = "establishment")
	private Collection<LanguageExchange> langsExchange;
}
