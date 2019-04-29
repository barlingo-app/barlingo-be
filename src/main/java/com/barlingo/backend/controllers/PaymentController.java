package com.barlingo.backend.controllers;

import java.io.IOException;
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
import com.barlingo.backend.models.services.EstablishmentServiceImpl;
import com.barlingo.backend.payment.PaymentServiceImpl;
import com.barlingo.backend.utilities.RestError;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/payments")
public class PaymentController {

  @Autowired
  private PaymentServiceImpl paymentService;

  @Autowired
  private EstablishmentServiceImpl establishmentService;

  @GetMapping("")
  public String getOrder(@RequestParam("orderId") String orderId) {
    String res;
    try {
      res = paymentService.getStringOrder(orderId);
    } catch (IOException e) {
      Assert.isTrue(false, RestError.ESTABLISHMENT_PAYMENT_IO);
      res = e.getMessage();
    }
    return res;
  }

  @PostMapping("")
  public void createPayment(@RequestParam("estId") Integer estId,
      @RequestParam("orderId") String orderId) {

    Establishment establishment;

    establishment = this.establishmentService.findById(estId);
    try {
      this.paymentService.createAndSave(establishment, orderId);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

  }

  @PutMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public String updatePayment() {
    return null;
  }
}
