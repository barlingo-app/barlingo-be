package com.barlingo.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.NotificationDTO;
import com.barlingo.backend.models.mapper.NotificationMapper;
import com.barlingo.backend.models.services.INotificationService;
import com.barlingo.backend.utilities.ResponseBody;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/notifications")
public class NotificationRestController extends AbstractRestController {

  @Autowired
  private INotificationService notificationService;

  @Autowired
  NotificationMapper notificationMapper;


  @GetMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> getNotifications(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal) {
    ResponseEntity<ResponseBody> result;
    try {
      List<NotificationDTO> notifications =
          this.notificationService.getMyNotReadNotifications(principal);
      result = this.createResponse(notifications);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @PostMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<ResponseBody> sendNotification(@RequestBody NotificationDTO notification) {
    ResponseEntity<ResponseBody> result;
    try {
      NotificationDTO not = this.notificationService.notify(notification);
      result = this.createResponse(not);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTABLISHMENT')")
  public void updateNotification(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id) {

    notificationService.markAsRead(id, principal);
  }


}
