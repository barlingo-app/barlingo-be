package com.barlingo.backend.models.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.barlingo.backend.models.dtos.ParticipantDTO;
import com.barlingo.backend.models.entities.User;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {

  ParticipantDTO entityToDto(User participant);

  List<ParticipantDTO> entitysToDtos(List<User> participant);

  User dtoToEntity(ParticipantDTO participant);

}
