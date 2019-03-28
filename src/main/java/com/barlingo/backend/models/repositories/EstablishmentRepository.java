package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Integer> {

}
