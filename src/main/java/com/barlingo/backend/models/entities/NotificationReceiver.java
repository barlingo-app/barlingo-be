package com.barlingo.backend.models.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Access(AccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class NotificationReceiver extends DomainEntity {

  ////////////////
  // Attributes //
  ////////////////

  private Boolean isRead;

  ///////////////
  // Relations //
  ///////////////
  @ManyToOne(fetch = FetchType.LAZY)
  @NotNull
  private Actor receiver;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotNull
  private Notification notification;

  public NotificationReceiver(
      @NotNull Actor receiver,
      @NotNull Notification notification) {
    this.receiver = receiver;
    this.notification = notification;
  }

  //  @ManyToMany(fetch = FetchType.LAZY)
//  @NotNull
//  private Collection<Actor> receivers;

}
