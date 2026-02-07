package com.designpatterns.behavioral.chainOfResponsibility;

// Concrete Handler 2
class Manager extends Approver {

    public void approve(int amount) {
        if (amount <= 5000) {
            System.out.println("Manager approved amount: " + amount);
        } else if (next != null) {
            next.approve(amount);
        }
    }
}