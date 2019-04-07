package com.barlingo.backend.models.mapper;

import com.barlingo.backend.models.dtos.UserDiscountGenericDTO;
import com.barlingo.backend.models.entities.UserDiscount;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDiscountMapper {

  UserDiscountMapper INSTANCE = Mappers.getMapper(UserDiscountMapper.class);

  @Mapping(target = "userId", source = "entity.user.id")
  @Mapping(target = "langExchangeId", source = "entity.langExchange.id")
  UserDiscountGenericDTO entityToDto(UserDiscount entity);

  UserDiscount dtoToEntity(UserDiscountGenericDTO dto);

  List<UserDiscountGenericDTO> entitysToDtos(List<UserDiscount> users);

}
