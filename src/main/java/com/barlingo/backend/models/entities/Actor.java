package com.barlingo.backend.models.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	private String password;

	private String username;

	@ElementCollection(fetch = FetchType.EAGER)
	List<Role> roles;

	///////////////
	// Relations //
	///////////////
	// TODO: add userAccount
	@OneToMany(fetch = FetchType.LAZY)
	@NotNull
	@Valid
	private Collection<Notification> notifications;
}
