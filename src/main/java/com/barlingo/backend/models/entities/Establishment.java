package com.barlingo.backend.models.entities;

import java.util.Collection;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class Establishment extends Actor {

  ////////////////
  // Attributes //
  ////////////////
  @NotBlank
  @SafeHtml
  private String establishmentName;

  @SafeHtml
  private String description;

  @NotBlank
  @SafeHtml
  private String address;

  //@NotNull
  @ElementCollection
  @Column(length = 3000)
  private Collection<String> images;

  @URL
  //@NotBlank
  @SafeHtml
  @Column(length = 3000)
  private String imageProfile;

  @NotBlank
  @SafeHtml
  private String workingHours;

  @SafeHtml
  private String offer;

  ///////////////
  // Relations //
  ///////////////
  @OneToOne
  @Valid
  private SubscriptionData subscription;

  @OneToMany(mappedBy = "establishment")
  @Valid
  private Collection<LanguageExchange> langsExchange;

}
