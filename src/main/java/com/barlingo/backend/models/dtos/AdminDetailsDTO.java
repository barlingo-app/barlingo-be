package com.barlingo.backend.models.dtos;

import lombok.Data;

@Data
public class AdminDetailsDTO {

  private Integer id;
  private String name;
  private String surname;
  private String country;
  private String city;
  private String email;
  private UserAccountGenericDTO userAccount;

}
