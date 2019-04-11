package com.barlingo.backend.models.entities;

import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class PayData extends DomainEntity {
  // TODO: revisar esta clase con los métodos de pago

  ////////////////
  // Attributes //
  ////////////////
  @NotNull
  private String orderId;

  @NotNull
  @SafeHtml
  private String title;

  @NotNull
  @SafeHtml
  private String payType;

  @Basic
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private LocalDateTime moment;

  ///////////////
  // Relations //
  ///////////////

}
