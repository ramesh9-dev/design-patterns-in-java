package com.designpatterns.behavioral.chainOfResponsibility;

// Handler abstract class
abstract class Approver {

    protected Approver next;

    public void setNext(Approver next) {
        this.next = next;
    }

    public abstract void approve(int amount);
}