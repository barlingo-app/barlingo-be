package com.barlingo.backend.models.services;

import com.barlingo.backend.models.dtos.NotificationDTO;
import java.util.List;

public interface INotificationService {

  NotificationDTO notify(NotificationDTO notificationDTO);

  void markAsRead(Integer notificationId, org.springframework.security.core.userdetails.User principal);

  NotificationDTO findById(Integer id);

  List<NotificationDTO> getMyNotReadNotifications(
      org.springframework.security.core.userdetails.User principal);
}
