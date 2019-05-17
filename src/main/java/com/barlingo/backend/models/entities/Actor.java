package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import com.barlingo.backend.security.UserAccount;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Access(AccessType.FIELD)
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Actor extends DomainEntity {

  ////////////////
  // Attributes //
  ////////////////
  @NotBlank
  @SafeHtml
  private String name;

  @NotBlank
  @SafeHtml
  private String surname;

  @NotBlank
  @SafeHtml
  private String country;

  @NotBlank
  @SafeHtml
  private String city;

  @Email
  @NotBlank
  @SafeHtml
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  private UserAccount userAccount;

  ///////////////
  // Relations //
  ///////////////
}
