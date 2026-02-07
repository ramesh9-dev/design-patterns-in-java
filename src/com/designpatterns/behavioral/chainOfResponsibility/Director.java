package com.designpatterns.behavioral.chainOfResponsibility;

// Concrete Handler 3
class Director extends Approver {

    public void approve(int amount) {
        if (amount <= 20000) {
            System.out.println("Director approved amount: " + amount);
        } else {
            System.out.println("Amount " + amount + " requires board approval");
        }
    }
}
