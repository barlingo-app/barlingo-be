package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.NotificationReceiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationReceiverRepository extends
    JpaRepository<NotificationReceiver, Integer> {

}
