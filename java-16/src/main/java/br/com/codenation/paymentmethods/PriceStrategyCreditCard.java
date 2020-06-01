package br.com.codenation.paymentmethods;

public class PriceStrategyCreditCard implements PriceStrategy {
    @Override
    public Double calculate(Double price) {
        return price * 0.98;
    }
}
