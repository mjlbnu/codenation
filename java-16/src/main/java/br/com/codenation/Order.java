package br.com.codenation;

import br.com.codenation.paymentmethods.PaymentMethod;

import java.util.Arrays;

public class Order {

    private Double price;
    private PaymentMethod paymentMethod;

    public Order(Double price, PaymentMethod paymentMethod) {
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    public Double getPrice() {
        return price;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Double calculate() {
      //PaymentMethod[] paymentMethods = paymentMethod.values();

      // For Each
      /*
      for (PaymentMethod method : paymentMethods) {
        if (method.name().equals(this.getPaymentMethod().name())) {
          return this.getPaymentMethod().getPaymentStrategy().calculate(this.getPrice());
        }
      }
      */

      // Java Stream
      if (Arrays.stream(PaymentMethod.values())
        .anyMatch((t) -> t.name().equals(this.getPaymentMethod().name()))) {
        return this.getPaymentMethod().getPaymentStrategy().calculate(this.getPrice());
      }

      throw new RuntimeException("Payment method not implemented");
    }

}
