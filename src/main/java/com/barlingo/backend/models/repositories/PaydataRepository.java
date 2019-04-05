package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.PayData;

public interface PaydataRepository extends JpaRepository<PayData, Integer> {

}
