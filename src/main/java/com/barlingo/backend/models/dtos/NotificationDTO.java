package com.barlingo.backend.models.dtos;

import com.barlingo.backend.models.entities.NotificationPriority;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class NotificationDTO {

  ////////////////
  // Attributes //
  ////////////////
  private Integer id;

  @NotBlank
  @SafeHtml
  private String title;

  @NotBlank
  @SafeHtml
  private String description;

  private Boolean isRead;

  @Basic
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private LocalDateTime moment;

  @Enumerated(EnumType.STRING)
  private NotificationPriority priority;

}
