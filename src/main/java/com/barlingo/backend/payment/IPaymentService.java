package com.barlingo.backend.payment;

import java.io.IOException;
import com.paypal.orders.Order;

public interface IPaymentService {

  String getStringOrder(String orderID) throws IOException;

  Order getOrder(String orderID) throws IOException;
}
