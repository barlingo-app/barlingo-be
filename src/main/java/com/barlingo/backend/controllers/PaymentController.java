package com.barlingo.backend.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.entities.PayData;
import com.barlingo.backend.models.entities.SubscriptionData;
import com.barlingo.backend.models.entities.SubscriptionType;
import com.barlingo.backend.models.services.EstablishmentServiceImpl;
import com.barlingo.backend.models.services.PayDataServiceImpl;
import com.barlingo.backend.models.services.SubscriptionDataServiceImpl;
import com.barlingo.backend.payment.PaymentServiceImpl;
import com.paypal.orders.Order;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/payments")
public class PaymentController {

  @Autowired
  private PaymentServiceImpl paymentService;

  @Autowired
  private EstablishmentServiceImpl establishmentService;

  @Autowired
  private SubscriptionDataServiceImpl subscriptionDataService;

  @Autowired
  private PayDataServiceImpl payDataService;

  @GetMapping("")
  public String getOrder(@RequestParam("orderId") String orderId) {
    String res;
    try {
      res = paymentService.getStringOrder(orderId);
    } catch (IOException e) {
      Assert.isTrue(false, "Error getting the order, orderID may be wrong");
      res = e.getMessage();
    }
    return res;
  }

  @PostMapping("")
  public void createPayment(@RequestParam("estId") Integer estId,
      @RequestParam("orderId") String orderId) {

    Establishment establishment;
    SubscriptionData subscriptionData, subscriptionDataSaved;
    SubscriptionType subType;
    PayData payData, payDataSaved;
    Order paypalOrder;
    LocalDateTime initMoment, endMoment;

    establishment = this.establishmentService.findById(estId);
    Assert.notNull(establishment, "establishment doesn't exists");

    Assert.isNull(establishment.getSubscription(), "establishment already haves a subscription");
    try {
      paypalOrder = this.paymentService.getOrder(orderId);

      Assert.isTrue(paypalOrder.status().equals("COMPLETED"),
          "Error with the payment order, order may not have been paid");
      Assert.isTrue(paypalOrder.purchaseUnits().get(0).payee().merchantId().equals("AG3N8JTUR4SNA"),
          "Payment order is not valid"); // Change this when sandbox vendor change change
      Assert.isNull(this.payDataService.findByOrderId(orderId),
          "that order belongs to another subscription");

      payData = this.payDataService.create();
      payData.setTitle("Paypal Order");
      payData.setOrderId(paypalOrder.id());
      payDataSaved = this.payDataService.save(payData);
      String createdTime = paypalOrder.createTime();

      payData.setMoment(LocalDateTime.now());
      try {
        if (createdTime != null)
          payData
              .setMoment(LocalDateTime.parse(createdTime.substring(0, createdTime.length() - 1)));
      } catch (DateTimeParseException pe) {
        payData.setMoment(LocalDateTime.now());
      }

      subscriptionData = this.subscriptionDataService.create();
      subscriptionData.setPaydata(payDataSaved);
      initMoment = payData.getMoment();
      switch (Integer.parseInt(paypalOrder.purchaseUnits().get(0).referenceId())) {
        case 1:
          subType = SubscriptionType.MONTHLY;
          endMoment = initMoment.plusMonths(1);
          break;
        case 2:
          subType = SubscriptionType.TRIMESTRAL;
          endMoment = initMoment.plusMonths(3);
          break;
        case 3:
          subType = SubscriptionType.ANNUAL;
          endMoment = initMoment.plusMonths(12);
          break;
        default:
          subType = SubscriptionType.MONTHLY;
          endMoment = initMoment.plusMonths(1);
      }
      subscriptionData.setSubscriptionType(subType);
      subscriptionData.setInitMoment(initMoment);
      subscriptionData.setFinishMoment(endMoment);
      subscriptionData
          .setPrice(Double.valueOf(paypalOrder.purchaseUnits().get(0).amount().value()));
      subscriptionDataSaved = this.subscriptionDataService.save(subscriptionData);

      establishment.setSubscription(subscriptionDataSaved);
      Assert.notNull(this.establishmentService.save(establishment),
          "error while saving subscription to the establishment");

    } catch (IOException e) {
      Assert.isTrue(false, "Error getting payment order");
    }

  }

  @PutMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public String updatePayment() {
    return null;
  }
}
