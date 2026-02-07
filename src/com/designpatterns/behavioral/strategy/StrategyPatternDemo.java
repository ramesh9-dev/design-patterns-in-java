package com.designpatterns.behavioral.strategy;

// Client
public class StrategyPatternDemo {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.makePayment(1000);

        context.setStrategy(new UPIPayment());
        context.makePayment(500);
    }
}