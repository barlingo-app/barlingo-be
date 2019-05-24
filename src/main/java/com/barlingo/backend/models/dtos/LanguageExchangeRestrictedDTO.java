package com.barlingo.backend.models.dtos;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class LanguageExchangeRestrictedDTO {

  private String title;
  private String description;
  private LocalDateTime moment;
  private Integer establishmentId;
  private String establishmentName;
  private Integer numberMaxParticipants;

}
