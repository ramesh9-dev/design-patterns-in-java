package com.designpatterns.behavioral.strategy;


// Concrete Strategy 2
class UPIPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}