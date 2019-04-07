package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.Establishment;
import java.util.Collection;

public interface IEstablishmentService {

  Collection<Establishment> findAll();

  Establishment save(Establishment establishment);

  Establishment findById(Integer id);

  void delete(Establishment establishment);

}
