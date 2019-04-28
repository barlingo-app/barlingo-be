package com.barlingo.backend.models.mapper;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.dtos.LanguageExchangeGenericDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LanguageExchangeMapper {

  LanguageExchangeMapper INSTANCE = Mappers.getMapper(LanguageExchangeMapper.class);

  LanguageExchangeDetailsDTO entityToDto(LanguageExchange langExchange);

  List<LanguageExchangeDetailsDTO> entitysToDtos(List<LanguageExchange> langsExchanges);

  LanguageExchange dtoToEntity(LanguageExchangeDetailsDTO LanguageExchange);

  List<LanguageExchangeGenericDTO> entitiesToDtosGeneric(List<LanguageExchange> langsExchanges);

  @Mapping(source = "langExchange.establishment.id", target = "establishmentId")
  @Mapping(source = "langExchange.establishment.establishmentName", target = "establishmentName")
  LanguageExchangeGenericDTO entityToDtoGeneric(LanguageExchange langExchange);

}
