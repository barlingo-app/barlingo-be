package com.barlingo.backend.models.dtos;

import java.time.LocalDateTime;
import java.util.Collection;
import lombok.Data;

@Data
public class LanguageExchangeGenericDTO {

  private String title;
  private String description;
  private LocalDateTime moment;
  private UserDetailsDTO creator;
  private Integer establishmentId;
  private String establishmentName;
  private Collection<String> targetLangs;
  private Integer numberOfParticipants;
  private Collection<ParticipantDTO> participants;

}
