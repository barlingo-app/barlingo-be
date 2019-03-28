package com.barlingo.backend.models.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.barlingo.backend.models.dtos.UserDetailsDTO;
import com.barlingo.backend.models.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDetailsDTO entityToDto(User user);

    List<UserDetailsDTO> entitysToDtos(List<User> users);

    User dtoToEntity(UserDetailsDTO user);

}