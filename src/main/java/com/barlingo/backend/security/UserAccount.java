/*
 * UserAccount.java
 *
 * Copyright (C) 2017 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package com.barlingo.backend.security;

import com.barlingo.backend.models.entities.DomainEntity;
import com.barlingo.backend.models.entities.Role;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Access(AccessType.FIELD)
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAccount extends DomainEntity {

  // Constructors -----------------------------------------------------------

  private static final long serialVersionUID = 7254823034213841482L;


  public UserAccount() {
    super();

//		this.authorities = new ArrayList<Authority>();
  }

  // Attributes -------------------------------------------------------------

  // UserDetails interface --------------------------------------------------

  private String username;
  private String password;
  @ElementCollection(fetch = FetchType.EAGER)
  List<Role> roles;
  private Boolean active;

}
