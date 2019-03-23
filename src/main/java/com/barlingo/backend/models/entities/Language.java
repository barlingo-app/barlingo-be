package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Access(AccessType.PROPERTY)
@Data
@EqualsAndHashCode(callSuper=false)
public class Language extends DomainEntity {

	@NotBlank
	@SafeHtml
	private String name;

	@NotBlank
	@SafeHtml
	private String code;

	@URL
	@NotBlank
	@SafeHtml
	private String image;
}
