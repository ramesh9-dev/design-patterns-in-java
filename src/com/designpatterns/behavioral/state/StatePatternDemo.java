package com.designpatterns.behavioral.state;

// Client
public class StatePatternDemo {

    public static void main(String[] args) {

        OrderContext order = new OrderContext();

        order.printStatus();
        order.next();

        order.printStatus();
        order.next();

        order.printStatus();
        order.next();

        order.printStatus();
    }
}