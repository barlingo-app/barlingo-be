package com.barlingo.backend.models.dtos;

import java.util.Collection;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import com.barlingo.backend.models.entities.SubscriptionData;
import lombok.Data;

@Data
public class EstablishmentDetailsDTO {

  private Integer id;
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
  @NotBlank
  @SafeHtml
  private String establishmentName;
  @Email
  @NotBlank
  @SafeHtml
  private String email;
  @SafeHtml
  private String description;
  @SafeHtml
  @NotBlank
  private String address;
  @SafeHtml
  private String imageProfile;
  private Collection<String> images;
  @SafeHtml
  private String offer;
//  private SubscriptionData subscription;
  @SafeHtml
  private String workingHours;

//  private UserAccountGenericDTO userAccount;

}
