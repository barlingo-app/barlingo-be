package com.barlingo.backend.models.entities;

public enum SubscriptionType {

  MONTHLY(1), TRIMESTRAL(3), ANNUAL(12);

  private Integer type;

  private SubscriptionType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

}
