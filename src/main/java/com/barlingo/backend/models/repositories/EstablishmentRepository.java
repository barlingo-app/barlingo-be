package com.barlingo.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.barlingo.backend.models.entities.Establishment;

public interface EstablishmentRepository extends CrudRepository<Establishment, Integer> {

}
