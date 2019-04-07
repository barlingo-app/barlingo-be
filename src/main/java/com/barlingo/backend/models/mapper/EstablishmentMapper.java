package com.barlingo.backend.models.mapper;

import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.entities.Establishment;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

  EstablishmentMapper INSTANCE = Mappers.getMapper(EstablishmentMapper.class);

  List<EstablishmentGenericDTO> establishmentsToDtos(Collection<Establishment> establishments);

  EstablishmentDetailsDTO establishmentToDto(Establishment establishment);

}
