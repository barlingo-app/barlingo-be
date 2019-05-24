package com.barlingo.backend.models.mapper;

import org.mapstruct.Mapper;
import com.barlingo.backend.models.dtos.UserAccountGenericDTO;
import com.barlingo.backend.security.UserAccount;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

  UserAccountGenericDTO entityToDto(UserAccount user);

  UserAccount dtoToEntity(UserAccountGenericDTO user);

}
