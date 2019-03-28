package com.barlingo.backend.models.mapper;

import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.entities.Establishment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

    EstablishmentMapper INSTANCE = Mappers.getMapper(EstablishmentMapper.class);


    EstablishmentDetailsDTO entityToDto(Establishment establishment);

    List<EstablishmentGenericDTO> entitysToDtos(List<Establishment> establishments);

    Establishment dtoToEntity(EstablishmentGenericDTO establishment);

}