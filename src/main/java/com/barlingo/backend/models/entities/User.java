package com.barlingo.backend.models.entities;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "users")
public class User  extends Actor {

	////////////////
	// Attributes //
	////////////////
	@URL
	@NotBlank
	@SafeHtml
	private String personalPic;

	@URL
	@SafeHtml
	private String profileBackPic;

	@NotBlank
	@SafeHtml
	private String aboutMe;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date birthDay;

	@SafeHtml
	private String location;

	///////////////
	// Relations //
	///////////////
	@OneToMany(fetch = FetchType.LAZY)
	@Valid
	@NotNull
	private Collection<LanguageExchange> langsExchanges;
	
	// fetch = FetchType.LAZY ->
	// no se trae esta collection cuando se llama al user,solo cuando es necesario
	@OneToMany(fetch = FetchType.LAZY)
	@NotNull
	@Valid
	private Collection<Language> speakLangs;

	@OneToMany(fetch = FetchType.LAZY)
	@NotNull
	@Valid
	private Collection<Language> langsToLearn;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Language motherTongue;

}
