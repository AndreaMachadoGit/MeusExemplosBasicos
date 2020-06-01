package br.com.codenation.paymentmethods;

public class PriceStrategyCash implements PriceStrategy {

    @Override
    public Double calculate(Double price) {
        return price * 0.9;
    }

}
