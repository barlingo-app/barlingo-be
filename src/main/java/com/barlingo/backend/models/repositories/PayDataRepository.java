package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.PayData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayDataRepository extends JpaRepository<PayData, Integer> {

}
