package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.SafeHtml;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Access(AccessType.PROPERTY)
@Data
@EqualsAndHashCode(callSuper = false)
public class ExchangeState extends DomainEntity {

	////////////////
	// Attributes //
	////////////////
	@NotBlank
	@SafeHtml
	@Pattern(regexp = "^(OPEN|CLOSED)$")
	private String name;

}
