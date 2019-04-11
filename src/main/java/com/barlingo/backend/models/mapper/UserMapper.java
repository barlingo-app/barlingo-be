package com.barlingo.backend.models.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.barlingo.backend.models.dtos.UserDetailsDTO;
import com.barlingo.backend.models.dtos.UserEditDTO;
import com.barlingo.backend.models.dtos.UserSigninDTO;
import com.barlingo.backend.models.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserDetailsDTO entityToDetailsDto(User user);

  List<UserDetailsDTO> entitysToDetailsDtos(List<User> users);

  User detailsDtoToEntity(UserDetailsDTO user);

  @Mapping(source = "user.birthdate", target = "birthday")
  @Mapping(source = "user.speakLanguages", target = "speakLangs")
  @Mapping(source = "user.learnLanguages", target = "langsToLearn")
  User editDtoToEntity(UserEditDTO user);

  @Mapping(source = "user.birthday", target = "birthdate")
  @Mapping(source = "user.speakLangs", target = "speakLanguages")
  @Mapping(source = "user.langsToLearn", target = "learnLanguages")
  UserEditDTO entityToEditDTO(User user);

  @Mapping(source = "user.birthdate", target = "birthday")
  @Mapping(source = "user.speakLanguages", target = "speakLangs")
  @Mapping(source = "user.learnLanguages", target = "langsToLearn")
  User signinDtoToEntity(UserSigninDTO user);

  @Mapping(source = "user.birthday", target = "birthdate")
  @Mapping(source = "user.speakLangs", target = "speakLanguages")
  @Mapping(source = "user.langsToLearn", target = "learnLanguages")
  UserSigninDTO entityToSigninDTO(User user);


}
