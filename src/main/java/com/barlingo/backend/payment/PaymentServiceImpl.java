package com.barlingo.backend.payment;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.barlingo.backend.models.entities.Configuration;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.PayData;
import com.barlingo.backend.models.entities.SubscriptionData;
import com.barlingo.backend.models.entities.SubscriptionType;
import com.barlingo.backend.models.repositories.ConfigurationRepository;
import com.barlingo.backend.models.services.IEstablishmentService;
import com.barlingo.backend.models.services.IPayDataService;
import com.barlingo.backend.models.services.ISubscriptionDataService;
import com.barlingo.backend.utilities.RestError;
import com.braintreepayments.http.HttpResponse;
import com.braintreepayments.http.serializer.Json;
import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersGetRequest;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {

  @Autowired
  private ISubscriptionDataService subscriptionData;
  @Autowired
  private IPayDataService payDataService;
  @Autowired
  private IEstablishmentService establishmentService;
  @Autowired
  private ConfigurationRepository configurationRepository;

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

  public void createAndSave(Establishment est, String orderId)
      throws IOException, IllegalArgumentException {
    Establishment establishment;
    SubscriptionData subData, subDataSaved;
    SubscriptionType subType;
    PayData payData, payDataSaved;
    Order paypalOrder;
    LocalDateTime payTime;
    Integer subNum;
    Configuration conf = this.configurationRepository.findAll().get(0);

    Assert.notNull(orderId, RestError.ESTABLISHMENT_PAYMENT_ORDER_ID_NOT_NULL);
    Assert.notNull(est, RestError.ESTABLISHMENT_PAYMENT_ESTABLISHMENT_NOT_EXISTS);
    establishment = this.establishmentService.findById(est.getId());
    Assert.isNull(establishment.getSubscription(),
        RestError.ESTABLISHMENT_PAYMENT_ESTABLISHMENT_ALREADY_HAVES_SUBSCRIPTION);

    try {
      paypalOrder = this.getOrder(orderId);
    } catch (Exception e) {
      throw new IOException(RestError.ESTABLISHMENT_PAYMENT_ORDER_IS_NOT_VALID);
    }
    Assert.isTrue(paypalOrder.status().equals("COMPLETED"),
        RestError.ESTABLISHMENT_PAYMENT_ERROR_PROCESING_ORDER);
    Assert.isTrue(
        paypalOrder.purchaseUnits().get(0).payee().merchantId().equals(conf.getPaypalVendorId()),
        RestError.ESTABLISHMENT_PAYMENT_ORDER_IS_NOT_VALID);
    Assert.isNull(this.payDataService.findByOrderId(orderId),
        RestError.ESTABLISHMENT_PAYMENT_ORDER_BELONGS_TO_ANOTHER_SUBSCRIPTION);

    try {
      payTime = LocalDateTime
          .parse(paypalOrder.createTime().substring(0, paypalOrder.createTime().length() - 1));
    } catch (Exception e) {
      payTime = LocalDateTime.now();
    }

    payData = this.payDataService.create(payTime, orderId);
    payDataSaved = this.payDataService.save(payData);

    try {
      subNum = Integer.parseInt(paypalOrder.purchaseUnits().get(0).referenceId());
    } catch (NumberFormatException ne) {
      throw new IllegalArgumentException(
          RestError.ESTABLISHMENT_PAYMENT_ERROR_PROCESING_SUBSCRIPTION);
    }
    switch (subNum) {
      case 1:
        subType = SubscriptionType.MONTHLY;
        break;
      case 2:
        subType = SubscriptionType.TRIMESTRAL;
        break;
      case 3:
        subType = SubscriptionType.ANNUAL;
        break;
      default:
        throw new IllegalArgumentException(
            RestError.ESTABLISHMENT_PAYMENT_ERROR_PROCESING_SUBSCRIPTION);
    }

    subData = this.subscriptionData.create(subType, payTime);
    subData.setPrice(Double.valueOf(paypalOrder.purchaseUnits().get(0).amount().value()));
    subData.setPaydata(payDataSaved);
    subDataSaved = this.subscriptionData.save(subData);

    establishment.setSubscription(subDataSaved);
    this.establishmentService.save(establishment);
  }// createAndSave



}
