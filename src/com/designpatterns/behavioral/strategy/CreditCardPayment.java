package com.designpatterns.behavioral.strategy;

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}