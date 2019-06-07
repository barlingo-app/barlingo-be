package com.barlingo.backend.models.dtos;

import java.util.Collection;
import lombok.Data;

@Data
public class ConfigurationDTO {

  private String companyName;
  private Collection<String> languagesCode;
  private Double priceMonthSubscription;
  private Double trimestralDiscount;
  private Double annualDiscount;
  private Integer timeShowBeforeDiscount;
  private Integer timeShowAfterDiscount;
  private Integer timeJoinUserToExchange;
  private String paypalVendorId;

}
