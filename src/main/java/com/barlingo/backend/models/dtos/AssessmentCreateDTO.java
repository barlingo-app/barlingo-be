package com.barlingo.backend.models.dtos;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AssessmentCreateDTO {

  private Integer id;
  @NotNull(message = "required")
  private Boolean alike;
  @NotNull(message = "required")
  private Integer assessedUserId;
}
