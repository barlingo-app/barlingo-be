package com.barlingo.backend.models.dtos;

import java.util.Collection;
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
  private Collection<AssessmentDTO> assessments;
}
