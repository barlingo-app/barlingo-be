package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class UserDiscount extends DomainEntity {

	////////////////
	// Attributes //
	////////////////
	@Column(unique = true)
	@SafeHtml
	private String code;

	@NotNull
	private Boolean exchanged;

	@NotNull
	private Boolean visible;

	///////////////
	// Relations //
	///////////////
	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private User user;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private LanguageExchange langExchange;

}
