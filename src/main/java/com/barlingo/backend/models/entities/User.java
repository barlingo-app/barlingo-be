package com.barlingo.backend.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.SafeHtml;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@SafeHtml
	private String name;
	@NotNull
	@SafeHtml
	private String surname;
	@NotNull
	@SafeHtml
	@Size(min = 4, max = 30)
	private String username;
	@NotNull
	@SafeHtml
	private String address; // Optional
//	@Pattern(regexp = "(^$|[0-9]{9})")
	private String phone; // Optional
	@Email
	@NotNull
	@SafeHtml
	private String email;

}
