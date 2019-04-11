package com.barlingo.backend.payment;

import java.io.IOException;
import javax.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.braintreepayments.http.HttpResponse;
import com.braintreepayments.http.serializer.Json;
import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersGetRequest;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {


  private PayPalClient ppc;

  public PaymentServiceImpl() {
    super();
    this.ppc = new PayPalClient();
  }

  @Override
  public String getStringOrder(String orderID) throws IOException {
    PayPalHttpClient client = ppc.client();

    OrdersGetRequest request = new OrdersGetRequest(orderID);
    HttpResponse<Order> response = client.execute(request);

    // return response.result().toString();
    return new JSONObject(new Json().serialize(response.result())).toString();
  }

  @Override
  public Order getOrder(String orderId) throws IOException {
    PayPalHttpClient client = ppc.client();

    OrdersGetRequest request = new OrdersGetRequest(orderId);
    HttpResponse<Order> response = client.execute(request);
    return response.result();
  }



}
