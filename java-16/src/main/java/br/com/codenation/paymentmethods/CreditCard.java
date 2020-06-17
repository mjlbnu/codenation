package br.com.codenation.paymentmethods;

public class CreditCard implements PriceStrategy{

  final double discontAmount = 0.98;

  @Override
  public Double calculate(Double price) {
    return price * discontAmount;
  }
}
