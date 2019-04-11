package com.barlingo.backend.models.services;

import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.entities.Actor;
import com.barlingo.backend.models.entities.Establishment;
import java.util.Collection;
import org.springframework.validation.BindingResult;

public interface IEstablishmentService {

  Collection<Establishment> findAll();

  Establishment save(Establishment establishment);

  Establishment findById(Integer id);

  void delete(Establishment establishment);

  Actor findByUsername(String username);

  Establishment register(EstablishmentDetailsDTO establishmentData, BindingResult binding);

  Establishment edit(Integer id, EstablishmentDetailsDTO establishmentData, BindingResult binding);

}
