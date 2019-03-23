package com.barlingo.backend.models.entities;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class SubscriptionData extends DomainEntity {

	////////////////
	// Attributes //
	////////////////
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date initMoment;

	@NotNull
	private SubscriptionType subscriptionType;

	@NotNull
	@DecimalMin("0.0")
	private Double price;

	///////////////
	// Relations //
	///////////////

}
