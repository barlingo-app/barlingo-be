package com.barlingo.backend.models.dtos;

import java.util.Collection;
import java.util.Date;
import lombok.Data;

@Data
public class UserDetailsDTO {

  private Integer id;
  private String name;
  private String surname;
  private Date birthday;
  private String country;
  private String city;
  private String email;
  private String personalPic;
  private String profileBackPic;
  private String aboutMe;
  private Collection<String> speakLangs;
  private Collection<String> langsToLearn;
  private String motherTongue;
  private UserAccountGenericDTO userAccount;
  private Collection<AssessmentDTO> assessments;

}
