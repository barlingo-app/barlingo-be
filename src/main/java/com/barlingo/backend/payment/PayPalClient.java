package com.barlingo.backend.payment;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

public class PayPalClient {

  /**
   * Set up the PayPal Java SDK environment with PayPal access credentials. This sample uses
   * SandboxEnvironment. In production, use ProductionEnvironment.
   */
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
      "AVty7omS6cvIuMGKjMbAIq-xlbPQLyREkzj2HJQ5UkK0JnApk3rX8yLHcvdBrU974UZxav0JK-8fBg2c",
      "EJejQEcI_o3AHfyWkHGm5QiPMt1V7h_hAa6hHq7I-UzjyLwlUcSC0AhnBvlYBrZNS4KYuUQEYoC5d3M8");

  /**
   * PayPal HTTP client instance with environment that has access credentials context. Use to invoke
   * PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   * Method to get client object
   *
   * @return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}
