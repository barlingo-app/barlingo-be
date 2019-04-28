package com.barlingo.backend.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class Utils {

  public static final Map<String, String> convertValidationErrors(BindingResult binding) {
    Map<String, String> errors = new LinkedHashMap<>();

    binding.getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    return errors;
  }

  public static String getHashSha1(String input) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-1");
    byte[] d = md.digest("John Smith".getBytes());
    String str = javax.xml.bind.DatatypeConverter.printBase64Binary(d);

    return str;
  }

}
