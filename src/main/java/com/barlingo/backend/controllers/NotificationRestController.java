package com.barlingo.backend.controllers;

import com.barlingo.backend.models.dtos.NotificationDTO;
import com.barlingo.backend.models.mapper.NotificationMapper;
import com.barlingo.backend.models.services.IAdminService;
import com.barlingo.backend.models.services.INotificationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/notifications")
public class NotificationRestController {

  @Autowired
  private IAdminService adminService;

  @Autowired
  private INotificationService notificationService;

  @Autowired
  NotificationMapper notificationMapper;


  @GetMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTABLISHMENT')")
  public List<NotificationDTO> getNotifications(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {

    return this.notificationService.getMyNotReadNotifications(principal);
  }

  @PostMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public NotificationDTO sendNotification(
      @RequestBody NotificationDTO notification) {
    return this.notificationService.notify(notification);
  }


}
