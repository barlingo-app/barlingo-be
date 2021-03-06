package com.barlingo.backend.models.mapper;

import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.entities.Establishment;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

  List<EstablishmentGenericDTO> establishmentsToDtos(Collection<Establishment> establishments);

  @Mapping(target = "username", source = "establishment.userAccount.username")
  EstablishmentDetailsDTO establishmentToDto(Establishment establishment);

}
