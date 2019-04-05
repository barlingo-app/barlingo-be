package com.barlingo.backend.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class PayData extends DomainEntity {
	// TODO: revisar esta clase con los métodos de pago

	////////////////
	// Attributes //
	////////////////
	@NotNull
	@SafeHtml
	private String title;

	@NotNull
	@SafeHtml
	private String payType;

	@NotNull
//	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	private LocalDateTime moment;

	///////////////
	// Relations //
	///////////////

}
