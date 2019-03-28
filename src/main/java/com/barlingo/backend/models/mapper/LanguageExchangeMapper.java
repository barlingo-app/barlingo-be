package com.barlingo.backend.models.mapper;

import com.barlingo.backend.models.dtos.LanguageExchangeDetailsDTO;
import com.barlingo.backend.models.entities.LanguageExchange;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageExchangeMapper {

	LanguageExchangeMapper INSTANCE = Mappers.getMapper(LanguageExchangeMapper.class);

	LanguageExchangeDetailsDTO entityToDto(LanguageExchange langExchange);

	List<LanguageExchangeDetailsDTO> entitysToDtos(List<LanguageExchange> langExchanges);

	LanguageExchange dtoToEntity(LanguageExchangeDetailsDTO LanguageExchange);

}