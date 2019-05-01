package com.barlingo.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.Utils;

@ControllerAdvice
public class AbstractController {

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<ResponseBody> createMessageException(Throwable oops) {
    ResponseBody responseBody = new ResponseBody();

    responseBody.setSuccess(false);
    responseBody.setCode(500);
    responseBody.setMessage(oops.getMessage());

    return ResponseEntity.ok(responseBody);
  }

  public <T> ResponseEntity<ResponseBody> createResponse(T dto) {
    return this.createResponse(dto, null);
  }

  public <T> ResponseEntity<ResponseBody> createResponse(T dto, BindingResult binding) {
    ResponseBody responseBody = new ResponseBody();

    if (binding != null) {
      if (binding.hasErrors()) {
        responseBody.setSuccess(false);
        responseBody.setCode(400);
        responseBody.setValidationErrors(Utils.convertValidationErrors(binding));
      }
    } else {
      responseBody.setSuccess(true);
      responseBody.setCode(200);
      responseBody.setContent(dto);
    }

    return ResponseEntity.ok(responseBody);
  }

}
