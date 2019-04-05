package com.barlingo.backend.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Basic
	@NotNull
//	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	private LocalDateTime initMoment;

	@Enumerated(EnumType.STRING)
	private SubscriptionType subscriptionType;

	@NotNull
	@DecimalMin("0.0")
	private Double price;

	@Basic
	@NotNull
//	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	private LocalDateTime finishMoment;

//	@NotNull
//	@DecimalMin("0.0")
//	private Double finalPrice = discountPrice();

	///////////////
	// Relations //
	///////////////
	@Valid
	@NotNull
	@OneToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private PayData paydata;

	public LocalDateTime getFinishMoment() {
		Integer year = this.paydata.getMoment().getYear();
		Integer month = this.paydata.getMoment().getMonthValue();

		switch (this.subscriptionType) {
		case ANNUAL:
			year = year + 1;
			break;
		case TRIMESTRAL:
			month = (month + 3) % 12;
			break;
		default: // MONTHLY
			month = (month + 1) % 12;
			break;
		}
		return LocalDateTime.of(year, month, this.paydata.getMoment().getDayOfMonth(),
				this.paydata.getMoment().getHour(), this.paydata.getMoment().getMinute());
	}

//	private Double discountPrice() {
//		Double result;
//
//		switch (this.subscriptionType) {
//		case ANNUAL:
//			result = price * .25;
//			break;
//		case TRIMESTRAL:
//			result = price * .1;
//			break;
//		default: // MONTHLY
//			result = price;
//			break;
//		}
//		return result;
//	}

}
