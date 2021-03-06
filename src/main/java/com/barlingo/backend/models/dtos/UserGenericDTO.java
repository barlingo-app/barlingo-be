package com.barlingo.backend.models.dtos;

import java.util.Collection;
import lombok.Data;

@Data
public class UserGenericDTO {

  private Integer id;
  private String name;
  private String surname;
  private String personalPic;
  private Collection<String> speakLangs;
  private Collection<String> langsToLearn;
  private UserAccountGenericDTO userAccount;
}
