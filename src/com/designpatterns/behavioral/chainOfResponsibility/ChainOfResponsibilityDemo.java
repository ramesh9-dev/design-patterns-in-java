package com.designpatterns.behavioral.chainOfResponsibility;

// Client
public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {

        Approver teamLead = new TeamLead();
        Approver manager = new Manager();
        Approver director = new Director();

        teamLead.setNext(manager);
        manager.setNext(director);

        teamLead.approve(800);
        teamLead.approve(3000);
        teamLead.approve(15000);
        teamLead.approve(50000);
    }
}