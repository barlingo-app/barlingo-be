package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {

}
