package com.barlingo.backend.models.mapper;

import java.util.List;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.barlingo.backend.models.dtos.NotificationDTO;
import com.barlingo.backend.models.entities.Notification;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

  @Mapping(target = "isRead", expression = "java(entity.getReceivers().get(0).getIsRead())")
  NotificationDTO entityToDto(Notification entity);

  Notification dtoToEntity(NotificationDTO dto);

  List<NotificationDTO> entitysToDtos(List<Notification> users);

  NotificationDTO entityToDto(Optional<Notification> notification);
}
