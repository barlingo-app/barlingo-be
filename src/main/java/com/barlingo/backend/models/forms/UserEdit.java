package com.barlingo.backend.models.forms;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class UserEdit {

  @NotNull(message = "required")
  private Integer id;
  @NotBlank(message = "required")
  private String name;
  @NotBlank(message = "required")
  private String surname;
  @Email(message = "emailFormat")
  @NotBlank(message = "required")
  @SafeHtml(message = "safeHtml")
  private String email;
  @Basic
  @NotNull(message = "required")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthdate;
  @NotBlank(message = "required")
  private String country;
  @NotBlank(message = "required")
  private String city;
  @SafeHtml(message = "safeHtml")
  private String aboutMe;
  @ElementCollection
  @NotNull(message = "required")
  private Collection<String> speakLanguages;
  @ElementCollection
  @NotNull(message = "required")
  private Collection<String> learnLanguages;
  @NotNull(message = "required")
  @SafeHtml
  private String motherTongue;

}
