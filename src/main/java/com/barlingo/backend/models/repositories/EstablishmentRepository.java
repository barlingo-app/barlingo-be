package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.Establishment;

import javax.transaction.Transactional;

public interface EstablishmentRepository extends JpaRepository<Establishment, Integer> {
    boolean existsByUsername(String username);

    Establishment findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
