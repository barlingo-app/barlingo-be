package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.SafeHtml;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Access(AccessType.FIELD)
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Actor extends DomainEntity {

	////////////////
	// Attributes //
	////////////////
	@NotBlank
	@SafeHtml
	private String name;
	@NotBlank
	@SafeHtml
	private String surname;
	@NotBlank
	@SafeHtml
	private String country;
	@NotBlank
	@SafeHtml
	private String city;
	@Email
	@NotBlank
	@SafeHtml
	private String email;

	///////////////
	// Relations //
	///////////////
	// TODO: add userAccount
}
