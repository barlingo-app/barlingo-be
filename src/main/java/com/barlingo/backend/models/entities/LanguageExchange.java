package com.barlingo.backend.models.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class LanguageExchange extends DomainEntity {

	@NotBlank
	@SafeHtml
	private String title;

	@NotBlank
	@SafeHtml
	private String description;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date moment;

	@NotNull
	private ExchangeState exchangeState;

	///////////////
	// Relations //
	///////////////

	@ManyToOne(optional = false)
	private Establishment establishment;

	@ManyToOne(optional = false)
	private User creator;

	/*@ManyToMany(mappedBy = "langsExchange", fetch = FetchType.LAZY)
	private Collection<User> participants;*/

	@OneToMany(fetch = FetchType.LAZY)
	private Collection<Language> targetLangs;

	@OneToMany(mappedBy = "langExchange", fetch = FetchType.LAZY)
	private Collection<UserDiscount> userDiscount;
}
