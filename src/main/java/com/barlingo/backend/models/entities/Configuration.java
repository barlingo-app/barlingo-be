package com.barlingo.backend.models.entities;

import java.util.Collection;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Access(AccessType.FIELD)
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Configuration extends DomainEntity {

  ////////////////
  // Attributes //
  ////////////////
  @NotBlank
  @SafeHtml
  private String companyName;

  @NotNull
  @ElementCollection
  private Collection<String> languagesCode;

  @NotNull
  @DecimalMin("0.0")
  private Double priceMonthSubscription;

  @NotNull
  @DecimalMin("0.0")
  @DecimalMax("0.5")
  private Double trimestralDiscount;

  @NotNull
  @DecimalMin("0.0")
  @DecimalMax("0.8")
  private Double annualDiscount;

  @NotNull
  @Min(0)
  private Integer timeShowBeforeDiscount;

  @NotNull
  @Min(0)
  private Integer timeShowAfterDiscount;

  @NotNull
  @Min(0)
  private Integer timeJoinUserToExchange;

}
