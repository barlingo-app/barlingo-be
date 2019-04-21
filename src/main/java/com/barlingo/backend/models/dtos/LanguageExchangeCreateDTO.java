package com.barlingo.backend.models.dtos;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class LanguageExchangeCreateDTO {

  @NotBlank
  @SafeHtml
  private String title;
  @NotBlank
  @SafeHtml
  private String description;
  @Basic
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private LocalDateTime moment;
  private Integer creatorId;
  @NotNull
  private Integer establishmentId;
  @NotEmpty
  @ElementCollection
  private Collection<String> targetLangs;
  @NotNull
  @Min(2)
  private Integer numberOfParticipants;

}
