package com.barlingo.backend.models.dtos;

import java.util.Collection;
import lombok.Data;

@Data
public class UserExchangesDetailsDTO{
  private UserDetailsDTO userData;
  private Collection<LanguageExchangeGenericDTO> langsExchanges;

}
