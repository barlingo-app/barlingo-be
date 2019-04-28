package com.barlingo.backend.models.services;

import com.barlingo.backend.models.dtos.EstablishmentExchangesDetailsDTO;
import com.barlingo.backend.models.dtos.UserExchangesDetailsDTO;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.validation.BindingResult;
import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.entities.Establishment;

public interface IEstablishmentService {

  Collection<Establishment> findAll();

  Establishment save(Establishment establishment);

  Establishment findById(Integer id);

  void delete(Establishment establishment);

  Establishment findByUsername(String username);

  Establishment register(EstablishmentDetailsDTO establishmentData, BindingResult binding);

  Establishment edit(org.springframework.security.core.userdetails.User principal,
      EstablishmentDetailsDTO userData);

  List<Establishment> findByDateGreater(LocalDateTime date);

  Establishment activateDeactivateUser(Integer id);

  Establishment anonymize (Integer id);

  EstablishmentExchangesDetailsDTO exportData(org.springframework.security.core.userdetails.User principal, Integer userId);

}
