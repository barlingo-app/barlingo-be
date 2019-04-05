package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.SubscriptionData;

public interface SubscriptionDataRepository extends JpaRepository<SubscriptionData, Integer> {

}
