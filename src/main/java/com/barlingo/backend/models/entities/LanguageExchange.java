package com.barlingo.backend.models.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
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

	@Basic
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	private LocalDateTime moment;

	@Enumerated(EnumType.STRING)
	@NotNull
	private ExchangeState exchangeState;

	@NotNull
	@Min(value = 0)
	private Integer numberMaxParticipants;

	@NotNull
	@ElementCollection
	private Collection<String> targetLangs;

	///////////////
	// Relations //
	///////////////
	@ManyToOne(optional = false)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "langExchange")
	@Valid
	@NotNull
	private Collection<UserDiscount> userDiscounts;
}
