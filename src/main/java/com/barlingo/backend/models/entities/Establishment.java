package com.barlingo.backend.models.entities;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@Valid
	@NotNull
	private SubscriptionData subscription;

	@OneToMany(mappedBy = "establishment")
	@Valid
	private Collection<LanguageExchange> langsExchange;
}
