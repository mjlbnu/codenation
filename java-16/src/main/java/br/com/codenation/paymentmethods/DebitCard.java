package br.com.codenation.paymentmethods;

public class DebitCard implements PriceStrategy{

  final double discontAmount = 0.95;

  @Override
  public Double calculate(Double price) {
    return price * discontAmount;
  }
}
