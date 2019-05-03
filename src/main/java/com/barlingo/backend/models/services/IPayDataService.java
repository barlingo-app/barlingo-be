package com.barlingo.backend.models.services;

import java.time.LocalDateTime;
import java.util.List;
import com.barlingo.backend.models.entities.PayData;

public interface IPayDataService {

  PayData create();

  PayData create(LocalDateTime createTime, String orderId);

  List<PayData> findAll();

  PayData save(PayData payData);

  PayData findById(Integer id);

  void delete(PayData payData);

  PayData findByOrderId(String orderId);

}
