package com.barlingo.backend.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.barlingo.backend.models.dtos.UserDiscountGenericDTO;
import com.barlingo.backend.models.entities.UserDiscount;

@Mapper(componentModel = "spring")
public interface UserDiscountMapper {

	UserDiscountMapper INSTANCE = Mappers.getMapper(UserDiscountMapper.class);

	@Mapping(target = "userId", source = "entity.user.id")
	@Mapping(target = "langExchangeId", source = "entity.langExchange.id")
	UserDiscountGenericDTO entityToDto(UserDiscount entity);

	UserDiscount dtoToEntity(UserDiscountGenericDTO dto);

}
