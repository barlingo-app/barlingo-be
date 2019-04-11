package com.barlingo.backend.models.mapper;

import com.barlingo.backend.models.dtos.AdminDetailsDTO;
import com.barlingo.backend.models.entities.Admin;
import com.barlingo.backend.models.entities.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminMapper {

  AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

  AdminDetailsDTO entityToDto(Admin user);

  List<AdminDetailsDTO> entitysToDtos(List<Admin> admins);

  User dtoToEntity(AdminDetailsDTO admin);

}