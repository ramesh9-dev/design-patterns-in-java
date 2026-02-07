package com.designpatterns.behavioral.chainOfResponsibility;

// Concrete Handler 1
class TeamLead extends Approver {

    public void approve(int amount) {
        if (amount <= 1000) {
            System.out.println("Team Lead approved amount: " + amount);
        } else if (next != null) {
            next.approve(amount);
        }
    }
}