package com.barlingo.backend.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.entities.Establishment;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

	EstablishmentMapper INSTANCE = Mappers.getMapper(EstablishmentMapper.class);

	EstablishmentGenericDTO entityToDto(Establishment entity);

	Establishment dtoToEntity(EstablishmentGenericDTO dto);
}
