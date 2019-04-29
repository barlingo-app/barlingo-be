package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barlingo.backend.models.entities.PayData;
import com.barlingo.backend.models.repositories.PayDataRepository;
import com.barlingo.backend.utilities.RestError;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class PayDataServiceImpl implements IPayDataService {

  @Override
  public PayData create() {
    PayData res = new PayData();
    res.setMoment(LocalDateTime.now());
    res.setTitle("PayPal Order");
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
    Assert.notNull(save, RestError.ESTABLISHMENT_PAYMENT_ERROR_SAVING_PAYDATA);
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
    Assert.notNull(orderId, RestError.ESTABLISHMENT_PAYMENT_ORDER_ID_NOT_NULL);
    return this.payDataRepository.findByOrderId(orderId);
  }

  @Override
  public PayData create(LocalDateTime createTime, String orderId) {
    PayData res = this.create();

    if (createTime == null)
      createTime = LocalDateTime.now();

    res.setMoment(createTime);
    res.setOrderId(orderId);

    return res;
  }


}
