package com.barlingo.backend.models.dtos;

import lombok.Data;

@Data
public class EstablishmentGenericDTO {

  private Integer id;
  private String establishmentName;
  private String address;
  private String imageProfile;
  private String workingHours;

}
