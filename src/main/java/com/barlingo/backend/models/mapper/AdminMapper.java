package com.barlingo.backend.models.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.barlingo.backend.models.dtos.AdminDetailsDTO;
import com.barlingo.backend.models.entities.Admin;
import com.barlingo.backend.models.entities.User;

@Mapper(componentModel = "spring")
public interface AdminMapper {

  AdminDetailsDTO entityToDto(Admin user);

  List<AdminDetailsDTO> entitysToDtos(List<Admin> admins);

  User dtoToEntity(AdminDetailsDTO admin);

}
