package com.barlingo.backend.models.services;

import java.util.List;
import com.barlingo.backend.models.entities.PayData;

public interface IPayDataService {

  PayData create();

  List<PayData> findAll();

  PayData save(PayData payData);

  PayData findById(Integer id);

  void delete(PayData payData);
}
