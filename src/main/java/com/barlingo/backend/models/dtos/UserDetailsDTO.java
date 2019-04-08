package com.barlingo.backend.models.dtos;

import java.time.LocalDate;
import java.util.Collection;
import lombok.Data;

@Data
public class UserDetailsDTO {

  private Integer id;
  private String name;
  private String surname;
  private LocalDate birthday;
  private String country;
  private String city;
  private String email;
  private String personalPic;
  private String profileBackPic;
  private String aboutMe;
  private Collection<String> speakLangs;
  private Collection<String> langsToLearn;

}
