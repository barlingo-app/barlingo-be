package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barlingo.backend.models.entities.PayData;
import com.barlingo.backend.models.repositories.PayDataRepository;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class PayDataServiceImpl implements IPayDataService {

  @Override
  public PayData create() {
    PayData res = new PayData();
    res.setMoment(LocalDateTime.now());
    res.setPayType("Paypal");
    return res;
  }

  @Autowired
  private PayDataRepository payDataRepository;

  @Override
  public List<PayData> findAll() {
    return this.payDataRepository.findAll();
  }

  @Override
  public PayData save(PayData payData) {
    PayData save = this.payDataRepository.save(payData);
    Assert.notNull(save);
    return save;
  }

  @Override
  public PayData findById(Integer id) {
    return this.payDataRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(PayData payData) {
    this.payDataRepository.delete(payData);
  }

  @Override
  public PayData findByOrderId(String orderId) {
    Assert.notNull(orderId);
    return this.payDataRepository.findByOrderId(orderId);
  }


}
