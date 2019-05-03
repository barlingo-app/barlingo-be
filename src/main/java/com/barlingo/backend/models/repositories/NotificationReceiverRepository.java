package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.NotificationReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationReceiverRepository extends
    JpaRepository<NotificationReceiver, Integer> {

  @Query("select notifRec from NotificationReceiver notifRec where notifRec.receiver.id = :userId and notifRec.notification.id = :notificationId")
  NotificationReceiver findByNotificationReceiver(@Param("notificationId") Integer notificationId,
      @Param("userId") Integer userId);


}
