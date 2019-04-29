package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.List;
import com.barlingo.backend.models.entities.SubscriptionData;
import com.barlingo.backend.models.entities.SubscriptionType;

public interface ISubscriptionDataService {

  SubscriptionData create();

  SubscriptionData create(SubscriptionType subType, LocalDateTime initMoment);

  List<SubscriptionData> findAll();

  SubscriptionData save(SubscriptionData subscriptionData);

  SubscriptionData findById(Integer id);

  void delete(SubscriptionData subscriptionData);
}
