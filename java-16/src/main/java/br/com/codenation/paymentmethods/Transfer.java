package br.com.codenation.paymentmethods;

public class Transfer implements PriceStrategy {

  final double discontAmount = 0.92;

  @Override
  public Double calculate(Double price) {
    return price * discontAmount;
  }
}
