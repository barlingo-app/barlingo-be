package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.barlingo.backend.models.entities.SubscriptionData;
import com.barlingo.backend.models.repositories.SubscriptionDataRepository;

@Service
@Transactional
public class SubscriptionDataServiceImpl implements ISubscriptionDataService {

  @Autowired
  private SubscriptionDataRepository subscriptionDataRepository;

  @Override
  public SubscriptionData create() {
    SubscriptionData res = new SubscriptionData();
    res.setInitMoment(LocalDateTime.now());
    return res;
  }

  @Override
  public List<SubscriptionData> findAll() {
    return this.subscriptionDataRepository.findAll();
  }

  @Override
  public SubscriptionData save(SubscriptionData subscriptionData) {
    SubscriptionData saved;

    Assert.notNull(subscriptionData.getPaydata(), "paydata cannot be null");
    saved = subscriptionDataRepository.save(subscriptionData);
    Assert.notNull(saved, "subscription data cannot be null");
    return saved;
  }

  @Override
  public SubscriptionData findById(Integer id) {
    return this.subscriptionDataRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(SubscriptionData subscriptionData) {
    this.subscriptionDataRepository.delete(subscriptionData);
  }



}