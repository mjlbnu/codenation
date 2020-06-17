package br.com.codenation.paymentmethods;

public class Cash implements PriceStrategy {

  final double discontAmount = 0.9;

  @Override
  public Double calculate(Double price) {
    return price * discontAmount;
  }
}
