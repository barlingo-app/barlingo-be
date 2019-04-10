package com.barlingo.backend.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.barlingo.backend.models.dtos.UserAccountGenericDTO;
import com.barlingo.backend.security.UserAccount;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

  UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);

  UserAccountGenericDTO entityToDto(UserAccount user);

  UserAccount dtoToEntity(UserAccountGenericDTO user);

}
