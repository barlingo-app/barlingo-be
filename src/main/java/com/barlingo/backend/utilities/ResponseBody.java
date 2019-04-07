package com.barlingo.backend.utilities;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class ResponseBody {

  private Boolean success;
  private Integer code;
  private Map<String, String> validationErrors;
  private Object content;
  private String message;

}
