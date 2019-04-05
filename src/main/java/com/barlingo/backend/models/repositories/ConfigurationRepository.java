package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {

}
