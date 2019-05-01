package com.barlingo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.security.UserAccountSecurityService;
import com.barlingo.backend.utilities.ResponseBody;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/security")
public class SecurityController {

  @Autowired
  UserAccountSecurityService userAccountSecurityService;

  @PostMapping("/secret")
  public ResponseEntity<ResponseBody> changePassword(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @RequestParam(required = true) String username,
      @RequestParam(required = true) String secret) {

    ResponseBody responseBody = new ResponseBody();
    try {
      this.userAccountSecurityService.changePassword(principal, username, secret);
      responseBody.setCode(200);
      responseBody.setSuccess(true);
    } catch (Exception e) {
      responseBody.setCode(500);
      responseBody.setSuccess(false);
      responseBody.setMessage(e.getMessage());
    }

    return ResponseEntity.ok().body(responseBody);
  }
}
