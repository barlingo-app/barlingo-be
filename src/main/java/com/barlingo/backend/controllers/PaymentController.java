package com.barlingo.backend.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.barlingo.backend.utilities.ResponseBody;
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
  public ResponseEntity<ResponseBody> getOrder(@RequestParam("orderId") String orderId) {
    ResponseBody responseBody = new ResponseBody();
    String res;

    try {
      res = paymentService.getStringOrder(orderId);
      responseBody.setCode(200);
      responseBody.setSuccess(true);
      responseBody.setContent(res);
    } catch (IOException e) {
      responseBody.setCode(500);
      responseBody.setSuccess(false);
      responseBody.setMessage(RestError.ESTABLISHMENT_PAYMENT_IO);
    }
    return ResponseEntity.ok().body(responseBody);
  }

  @PostMapping("")
  public ResponseEntity<ResponseBody> createPayment(@RequestParam("estId") Integer estId,
      @RequestParam("orderId") String orderId) {
    ResponseBody responseBody = new ResponseBody();
    Establishment establishment;

    establishment = this.establishmentService.findById(estId);
    try {
      this.paymentService.createAndSave(establishment, orderId);
      responseBody.setCode(200);
      responseBody.setSuccess(true);
    } catch (Exception e) {
      responseBody.setCode(500);
      responseBody.setSuccess(false);
      responseBody.setMessage(e.getMessage());
    }

    return ResponseEntity.ok().body(responseBody);
  }

  @PutMapping("")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public String updatePayment() {
    return null;
  }
}
