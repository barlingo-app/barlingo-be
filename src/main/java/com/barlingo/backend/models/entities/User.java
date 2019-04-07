package com.barlingo.backend.models.entities;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
@Table(name = "users")
public class User extends Actor {

  ////////////////
  // Attributes //
  ////////////////
  @URL
  @NotBlank
  @SafeHtml
  private String personalPic;

  @URL
  @SafeHtml
  private String profileBackPic;

  @SafeHtml
  private String aboutMe;

  @Basic
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private LocalDate birthday;

  @SafeHtml
  private String location;

  @NotNull
  @ElementCollection
  private Collection<String> speakLangs;

  @NotNull
  @ElementCollection
  private Collection<String> langsToLearn;

  @NotNull
  @SafeHtml
  private String motherTongue;

  ///////////////
  // Relations //
  ///////////////
  // fetch = FetchType.LAZY ->
  // no se trae esta collection cuando se llama al user,solo cuando es necesario
  @ManyToMany(fetch = FetchType.LAZY)
  @Valid
  @NotNull
  private Collection<LanguageExchange> langsExchanges;

}
