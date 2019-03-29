package com.barlingo.backend.models.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class LanguageExchange extends DomainEntity {

	////////////////
	// Attributes //
	////////////////
	@NotBlank
	@SafeHtml
	private String title;

	@NotBlank
	@SafeHtml
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@NotNull
	@Basic
	private Date moment;

	///////////////
	// Relations //
	///////////////
	@ManyToOne(optional = false)
	@Valid
	private ExchangeState exchangeState;

	@ManyToOne(optional = false)
	@JoinColumn(name = "establishment_id")
	@NotNull
	@Valid
	private Establishment establishment;

	@ManyToOne(optional = false)
	@NotNull
	@Valid
	private User creator;

	@ManyToMany(mappedBy = "langsExchanges", fetch = FetchType.LAZY)
	@NotNull
	@Valid
	private Collection<User> participants;

	@OneToMany(fetch = FetchType.LAZY)
	@Valid
	@NotNull
	private Collection<Language> targetLangs;

	@OneToMany(fetch = FetchType.LAZY)
	@Valid
	@NotNull
	private Collection<UserDiscount> userDiscount;
}
