package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class Assessment extends DomainEntity {

  ////////////////
  // Attributes //
  ////////////////
  @NotNull
  private Boolean alike;

  ///////////////
  // Relations //
  ///////////////
  @ManyToOne(optional = false)
  @Valid
  @NotNull
  private User user;
  @ManyToOne(optional = false)
  @Valid
  @NotNull
  private User assessedUser;

}
