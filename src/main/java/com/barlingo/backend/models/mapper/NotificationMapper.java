package com.barlingo.backend.models.mapper;

import com.barlingo.backend.models.dtos.NotificationDTO;
import com.barlingo.backend.models.entities.Notification;
import java.util.List;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

  NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

  NotificationDTO entityToDto(Notification entity);

  Notification dtoToEntity(NotificationDTO dto);

  List<NotificationDTO> entitysToDtos(List<Notification> users);

  NotificationDTO entityToDto(Optional<Notification> notification);
}
