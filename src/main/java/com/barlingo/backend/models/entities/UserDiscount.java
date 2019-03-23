package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class UserDiscount extends DomainEntity {

	////////////////
	// Attributes //
	////////////////
	@SafeHtml
	private String code;

	@NotNull
	private Boolean exchanged;

	///////////////
	// Relations //
	///////////////
	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private LanguageExchange langExchange;

}
