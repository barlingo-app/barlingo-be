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

  private Integer id;
  @NotBlank(message = "required")
  @SafeHtml
  private String title;
  @NotBlank(message = "required")
  @SafeHtml
  private String description;
  private Boolean isRead;
  @Basic
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private LocalDateTime moment;
  @NotNull(message = "required")
  @Enumerated(EnumType.STRING)
  private NotificationPriority priority;

}
