package com.barlingo.backend.models.entities;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@Pattern(regexp = "^(MONTHLY|QUARTERLY|ANNUAL)$")
	private String subscriptionType;

	@NotNull
	@DecimalMin("0.0")
	private Double price;

	///////////////
	// Relations //
	///////////////
	@OneToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private PayData paydata;

}
