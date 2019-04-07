package com.barlingo.backend.models.dtos;

import lombok.Data;

@Data
public class ParticipantDTO {

  private Integer id;
  private String name;
  private String surname;
  private String country;
  private String city;
  private String personalPic;
  private String profileBackPic;
}
