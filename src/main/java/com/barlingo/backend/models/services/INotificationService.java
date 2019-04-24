package com.barlingo.backend.models.services;

import com.barlingo.backend.models.dtos.NotificationDTO;
import java.util.List;

public interface INotificationService {

  NotificationDTO notify(NotificationDTO notification);

  List<NotificationDTO> getMyNotReadNotifications(
      org.springframework.security.core.userdetails.User principal);
}
