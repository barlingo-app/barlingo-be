package com.barlingo.backend.models.entities;


import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	/*@ManyToMany
	private Collection<LanguageExchange> langsExchange;

	// fetch = FetchType.LAZY ->
	// no se trae esta collection cuando se llama al user,solo cuando es necesario
	@OneToMany(fetch = FetchType.LAZY)
	private Collection<Language> speakLangs;

	@OneToMany(fetch = FetchType.LAZY)
	private Collection<Language> langsToLearn;*/

	@ManyToOne
	private Language motherTongue;

}
