package com.designpatterns.behavioral.state;

// State Interface
interface OrderState {
    void next(OrderContext context);

    void printStatus();
}

// Concrete State 1
class CreatedState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new PaidState());
    }

    public void printStatus() {
        System.out.println("Order created");
    }
}

// Concrete State 2
class PaidState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new ShippedState());
    }

    public void printStatus() {
        System.out.println("Order paid");
    }
}

// Concrete State 3
class ShippedState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new DeliveredState());
    }

    public void printStatus() {
        System.out.println("Order shipped");
    }
}

// Concrete State 4
class DeliveredState implements OrderState {

    public void next(OrderContext context) {
        System.out.println("Order already delivered");
    }

    public void printStatus() {
        System.out.println("Order delivered");
    }
}
