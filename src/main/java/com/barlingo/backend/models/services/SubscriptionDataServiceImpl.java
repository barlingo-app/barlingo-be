package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.barlingo.backend.models.entities.SubscriptionData;
import com.barlingo.backend.models.entities.SubscriptionType;
import com.barlingo.backend.models.repositories.SubscriptionDataRepository;
import com.barlingo.backend.utilities.RestError;

@Service
@Transactional
public class SubscriptionDataServiceImpl implements ISubscriptionDataService {

  @Autowired
  private SubscriptionDataRepository subscriptionDataRepository;

  @Override
  public SubscriptionData create() {
    return new SubscriptionData();
  }

  @Override
  public List<SubscriptionData> findAll() {
    return this.subscriptionDataRepository.findAll();
  }

  @Override
  public SubscriptionData save(SubscriptionData subscriptionData) {
    SubscriptionData saved;

    Assert.notNull(subscriptionData.getPaydata(), RestError.ESTABLISHMENT_PAYMENT_PAYDATA_NOT_NULL);
    saved = subscriptionDataRepository.save(subscriptionData);
    Assert.notNull(saved, RestError.ESTABLISHMENT_PAYMENT_ERROR_SAVING_SUBSCRIPTION_DATA);
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

  @Override
  public SubscriptionData create(SubscriptionType subType, LocalDateTime initMoment) {
    SubscriptionData res = this.create();

    res.setInitMoment(initMoment);
    res.setSubscriptionType(subType);
    switch (subType) {
      case MONTHLY:
        res.setFinishMoment(initMoment.plusMonths(1));
        break;
      case TRIMESTRAL:
        res.setFinishMoment(initMoment.plusMonths(3));
        break;
      case ANNUAL:
        res.setFinishMoment(initMoment.plusYears(1));
        break;
    }
    return res;
  }



}
