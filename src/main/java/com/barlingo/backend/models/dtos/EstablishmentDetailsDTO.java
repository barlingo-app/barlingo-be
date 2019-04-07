package com.barlingo.backend.models.dtos;

import java.util.Collection;
import lombok.Data;

@Data
public class EstablishmentDetailsDTO {

  private Integer id;
  private String establishmentName;
  private String description;
  private String address;
  private String imageProfile;
  private Collection<String> images;

  //TODO Find the way to note the tuple contains two Date objects
  private String workingHours;

}
