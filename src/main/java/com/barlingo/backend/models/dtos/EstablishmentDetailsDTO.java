package com.barlingo.backend.models.dtos;

import com.barlingo.backend.models.entities.PayData;
import com.barlingo.backend.models.entities.SubscriptionData;
import java.util.Collection;
import lombok.Data;

@Data
public class EstablishmentDetailsDTO {

  private Integer id;
  private String username;
  private String password;
  private String name;
  private String surname;
  private String country;
  private String city;
  private String email;
  private String title;
  private String establishmentName;
  private String description;
  private String address;
  private String imageProfile;
  private Collection<String> images;
  private String offer;
  private SubscriptionData subscription;

  //TODO Find the way to note the tuple contains two Date objects
  private String workingHours;

}
