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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class SubscriptionData extends DomainEntity {

//	@Value("${annualDiscount}")
//	private Integer annualDiscount;
//	@Value("${trimestralDiscount}")
//	private Integer trimestralDiscount;

  ////////////////
  // Attributes //
  ////////////////
  @Basic
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private LocalDateTime initMoment;

  @Enumerated(EnumType.STRING)
  private SubscriptionType subscriptionType;

  @NotNull
  @DecimalMin("0.0")
  private Double price;

  @Basic
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private LocalDateTime finishMoment;

  ///////////////
  // Relations //
  ///////////////
  @Valid
  @NotNull
  @OneToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.DETACH,
      CascadeType.REFRESH})
  private PayData paydata;


  public LocalDateTime getFiDateTime() {
    return getPaydata().getMoment().plusMonths(getSubscriptionType().getMonths());
  }

}
