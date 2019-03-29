package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.ExchangeState;

public interface ExchangeStateRepository extends JpaRepository<ExchangeState, Integer> {

}
