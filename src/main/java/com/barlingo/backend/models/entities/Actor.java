package com.barlingo.backend.models.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
  // TODO: add userAccount
//  @ManyToMany(mappedBy = "receivers", fetch = FetchType.LAZY)
//  @NotNull
//  @Valid
//  private Collection<Notification> notifications;

//  @OneToMany( mappedBy = "receiver" ,cascade = CascadeType.ALL,
//      orphanRemoval = true)
//  private List<NotificationReceiver> notifications = new ArrayList<>();
}
