package com.barlingo.backend.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.services.EstablishmentServiceImpl;
import com.barlingo.backend.payment.PaymentServiceImpl;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.RestError;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/payments")
@Log4j2
public class PaymentController extends AbstractRestController {

  @Autowired
  private PaymentServiceImpl paymentService;

  @Autowired
  private EstablishmentServiceImpl establishmentService;

  @GetMapping("")
  public ResponseEntity<ResponseBody> getOrder(@RequestParam("orderId") String orderId) {
    ResponseEntity<ResponseBody> result;
    String order;
    try {
      order = paymentService.getStringOrder(orderId);
      result = this.createResponse(order);
    } catch (IOException e) {
      Assert.isTrue(false, RestError.ESTABLISHMENT_PAYMENT_IO);
      result = this.createMessageException(e);
    }
    return result;
  }

  @PostMapping("")
  public ResponseEntity<ResponseBody> createPayment(@RequestParam("estId") Integer estId,
      @RequestParam("orderId") String orderId) {
    ResponseEntity<ResponseBody> result;
    Establishment establishment;

    establishment = this.establishmentService.findById(estId);
    try {
      this.paymentService.createAndSave(establishment, orderId);
      result = this.createResponse(orderId);
    } catch (Exception e) {
      log.error(e.getMessage());
      result = this.createMessageException(e);
    }
    return result;
  }

  @PutMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public String updatePayment() {
    return null;
  }
}
