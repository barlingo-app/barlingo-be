package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.validation.BindingResult;
import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.entities.Actor;
import com.barlingo.backend.models.entities.Establishment;

public interface IEstablishmentService {

  Collection<Establishment> findAll();

  Establishment save(Establishment establishment);

  Establishment findById(Integer id);

  void delete(Establishment establishment);

  Actor findByUsername(String username);

  Establishment register(EstablishmentDetailsDTO establishmentData, BindingResult binding);

  Establishment edit(Integer id, EstablishmentDetailsDTO establishmentData, BindingResult binding);

  List<Establishment> findByDateGreater(LocalDateTime date);

}
