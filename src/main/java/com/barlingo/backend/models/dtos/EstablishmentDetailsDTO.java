package com.barlingo.backend.models.dtos;

import com.barlingo.backend.models.validations.EditionValidation;
import com.barlingo.backend.models.validations.RegisterValidation;
import java.util.Collection;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.SafeHtml;
import com.barlingo.backend.models.entities.SubscriptionData;
import lombok.Data;

@Data
public class EstablishmentDetailsDTO {
  @NotNull(message = "required", groups = {EditionValidation.class})
  private Integer id;
  @NotBlank(message = "required", groups = {RegisterValidation.class})
  @SafeHtml
  private String username;
  @NotBlank(message = "required", groups = {RegisterValidation.class})
  @SafeHtml
  private String password;
  @NotBlank(message = "required")
  @SafeHtml
  private String name;
  @NotBlank(message = "required")
  @SafeHtml
  private String surname;
  @NotBlank(message = "required")
  @SafeHtml
  private String country;
  @NotBlank(message = "required")
  @SafeHtml
  private String city;
  @Email
  @NotBlank(message = "required")
  @SafeHtml
  private String email;
  @NotBlank(message = "required")
  @SafeHtml
  private String establishmentName;
  @SafeHtml
  private String description;
  @SafeHtml
  @NotBlank(message = "required")
  private String address;
  @SafeHtml
  private String imageProfile;
  private Collection<String> images;
  @SafeHtml
  private String offer;
  private SubscriptionData subscription;
  @NotBlank(message = "required")
  @SafeHtml
  private String workingHours;

  private UserAccountGenericDTO userAccount;
}
