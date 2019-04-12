package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.SubscriptionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionDataRepository extends JpaRepository<SubscriptionData, Integer> {

}
