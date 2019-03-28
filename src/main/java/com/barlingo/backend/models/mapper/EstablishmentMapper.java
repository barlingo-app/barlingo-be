package com.barlingo.backend.models.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.entities.Establishment;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

	EstablishmentMapper INSTANCE = Mappers.getMapper(EstablishmentMapper.class);

	List<EstablishmentGenericDTO> establishmentsToDtos(Collection<Establishment> establishments);
	
	EstablishmentGenericDTO entityToDto(Establishment entity);

	Establishment dtoToEntity(EstablishmentGenericDTO dto);
}
