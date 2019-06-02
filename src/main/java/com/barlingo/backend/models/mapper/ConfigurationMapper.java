package com.barlingo.backend.models.mapper;

import org.mapstruct.Mapper;
import com.barlingo.backend.models.dtos.ConfigurationDTO;
import com.barlingo.backend.models.entities.Configuration;

@Mapper(componentModel = "spring")
public interface ConfigurationMapper {

  ConfigurationDTO entityToDto(Configuration config);

  Configuration dtoToEntity(ConfigurationDTO config);

}
