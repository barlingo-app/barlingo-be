package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.barlingo.backend.models.entities.PayData;

public interface PayDataRepository extends JpaRepository<PayData, Integer> {

  public PayData findByOrderId(String orderId);

}
