package com.barlingo.backend.models.services;

import com.barlingo.backend.models.dtos.NotificationDTO;
import com.barlingo.backend.models.entities.Actor;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.Notification;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.mapper.NotificationMapper;
import com.barlingo.backend.models.repositories.ActorRepository;
import com.barlingo.backend.models.repositories.EstablishmentRepository;
import com.barlingo.backend.models.repositories.NotificationRepository;
import com.barlingo.backend.models.repositories.UserRepository;
import com.barlingo.backend.security.UserAccount;
import com.barlingo.backend.security.UserAccountRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NotificationServiceImpl implements INotificationService {

  @Autowired
  private NotificationRepository notificationRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private NotificationMapper notificationMapper;

  @Autowired
  private UserAccountRepository userAccountRepository;

  @Autowired
  private ActorRepository actorRepository;

  @Override
  public NotificationDTO notify(NotificationDTO notificationDTO) {
    Notification notification = notificationMapper.dtoToEntity(notificationDTO);

    List<Establishment> establishmentList = establishmentRepository.findAll();
    List<User> userList = userRepository.findAll();
    List<Actor> receivers = new ArrayList<>();
    receivers.addAll(establishmentList);
    receivers.addAll(userList);
    for (Actor receiver : receivers) {
      notification.addReceiver(receiver);
    }

    notification.setMoment(LocalDateTime.now());
    notification.setIsRead(false);

    return notificationMapper.entityToDto(this.notificationRepository.saveAndFlush(notification));
  }

  @Override
  public List<NotificationDTO> getMyNotReadNotifications(
      org.springframework.security.core.userdetails.User principal) {
    UserAccount userAccount = userAccountRepository.findByUsername(principal.getUsername());
    Actor actor = actorRepository.findByUserAccountId(userAccount.getId());
    List<NotificationDTO> result = this.notificationMapper
        .entitysToDtos(notificationRepository.findByReceiverNotRead(actor.getId()));

    return result;
  }
}
