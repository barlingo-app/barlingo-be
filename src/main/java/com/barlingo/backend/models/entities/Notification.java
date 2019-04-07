package com.barlingo.backend.models.entities;

import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public abstract class Notification extends DomainEntity {

  ////////////////
  // Attributes //
  ////////////////
  @NotBlank
  @SafeHtml
  private String title;

  @NotBlank
  @SafeHtml
  private String description;

  @NotBlank
  private Boolean isRead;

  @Basic
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private LocalDateTime moment;

  ///////////////
  // Relations //
  ///////////////
}
