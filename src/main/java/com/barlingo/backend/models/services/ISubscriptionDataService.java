package com.barlingo.backend.models.services;

import java.util.List;
import com.barlingo.backend.models.entities.SubscriptionData;

public interface ISubscriptionDataService {

  SubscriptionData create();

  List<SubscriptionData> findAll();

  SubscriptionData save(SubscriptionData subscriptionData);

  SubscriptionData findById(Integer id);

  void delete(SubscriptionData subscriptionData);
}
