package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.Notification;
import com.barlingo.backend.models.entities.NotificationReceiver;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

  @Query("select notif from Notification notif join notif.receivers rec where rec.receiver.id = :userId and rec.isRead=false order by priority asc")
  List<Notification> findByReceiverNotRead(@Param("userId") Integer userId);


}
