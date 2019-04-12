package com.barlingo.backend.models.dtos;

import java.util.Collection;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import com.barlingo.backend.models.entities.SubscriptionData;
import com.barlingo.backend.models.validations.RegisterValidation;
import lombok.Data;

@Data
public class EstablishmentDetailsDTO {

  private Integer id;
  @NotBlank(groups = {RegisterValidation.class})
  @SafeHtml
  private String username;
  @NotBlank(groups = {RegisterValidation.class})
  @SafeHtml
  private String password;
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
  @NotBlank
  @SafeHtml
  private String establishmentName;
  @SafeHtml
  private String description;
  private String address;
  @URL
  @SafeHtml
  private String imageProfile;
  private Collection<String> images;
  @SafeHtml
  private String offer;
  private SubscriptionData subscription;

  // TODO Find the way to note the tuple contains two Date objects
  @NotBlank
  @SafeHtml
  private String workingHours;

  private UserAccountGenericDTO userAccount;

}
