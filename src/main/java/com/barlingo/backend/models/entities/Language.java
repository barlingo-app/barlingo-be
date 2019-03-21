package com.barlingo.backend.models.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.Data;

@Entity
@Data
public class Language {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String code;
	
	@URL
	@NotBlank
	private String image;
}
