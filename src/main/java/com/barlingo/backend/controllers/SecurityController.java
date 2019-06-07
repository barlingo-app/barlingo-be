package com.barlingo.backend.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.security.UserAccountSecurityService;
import com.barlingo.backend.utilities.ResponseBody;

@RestController
@RequestMapping("/security")
public class SecurityController extends AbstractRestController {

  @Autowired
  UserAccountSecurityService userAccountSecurityService;

  @PostMapping("/secret")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> changePassword(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @RequestBody(required = true) Map<String, String> secret) {
    ResponseEntity<ResponseBody> result;

    try {
      this.userAccountSecurityService.changePassword(principal, secret.get("secret"));
      result = this.createResponse("Password.changed");
    } catch (Exception e) {
      result = this.createMessageException(e);
    }

    return result;
  }
}
