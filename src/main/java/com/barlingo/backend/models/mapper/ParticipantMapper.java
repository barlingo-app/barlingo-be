package com.barlingo.backend.models.mapper;

import com.barlingo.backend.models.dtos.ParticipantDTO;
import com.barlingo.backend.models.entities.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {

  ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);

  ParticipantDTO entityToDto(User participant);

  List<ParticipantDTO> entitysToDtos(List<User> participant);

  User dtoToEntity(ParticipantDTO participant);

}