package com.barlingo.backend.models.dtos;

import java.util.Collection;
import lombok.Data;

@Data
public class EstablishmentExchangesDetailsDTO {

  private EstablishmentDetailsDTO establishmentDetailsDTO;
  private Collection<LanguageExchangeGenericDTO> langsExchanges;

}
