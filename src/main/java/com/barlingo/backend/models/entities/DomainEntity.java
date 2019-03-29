package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Access(AccessType.FIELD)
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DomainEntity {

	////////////////
	// Attributes //
	////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Version
	private int version;

	

}
