package com.barlingo.backend.models.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class Notification extends DomainEntity {

  ////////////////
  // Attributes //
  ////////////////
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

  ///////////////
  // Relations //
  ///////////////

  @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
  private List<NotificationReceiver> receivers = new ArrayList<>();

  public void addReceiver(Actor receiver) {
    NotificationReceiver notificationReceiver = new NotificationReceiver(receiver, this);
    notificationReceiver.setIsRead(false);
    receivers.add(notificationReceiver);
//    receiver.getNotifications().add(notificationReceiver);
  }

}
