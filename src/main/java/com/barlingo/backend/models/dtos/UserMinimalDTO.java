package com.barlingo.backend.models.dtos;

import lombok.Data;

@Data
public class UserMinimalDTO {

  private Integer id;
  private String name;
  private String surname;
  private String personalPic;
}
