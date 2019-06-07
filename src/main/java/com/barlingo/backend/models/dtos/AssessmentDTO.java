package com.barlingo.backend.models.dtos;

import lombok.Data;

@Data
public class AssessmentDTO {

  private Integer id;
  private Boolean alike;
  private UserMinimalDTO user;
  private UserMinimalDTO assessedUser;
}
