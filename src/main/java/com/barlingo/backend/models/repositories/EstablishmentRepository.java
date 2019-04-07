package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepository extends JpaRepository<Establishment, Integer> {

}
