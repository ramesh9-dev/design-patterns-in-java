package com.designpatterns.behavioral.state;

// Context
class OrderContext {
    private OrderState state;

    public OrderContext() {
        state = new CreatedState();
    }

    void setState(OrderState state) {
        this.state = state;
    }

    void next() {
        state.next(this);
    }

    void printStatus() {
        state.printStatus();
    }
}