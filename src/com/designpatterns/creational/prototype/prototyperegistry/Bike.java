package com.designpatterns.creational.prototype.prototyperegistry;

// Bike class
class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String model, int price, boolean hasCarrier) {
        super(model, price);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public String toString() {
        return "Bike{model='" + getModel() + "', price=" + getPrice() + ", hasCarrier=" + hasCarrier + "}";
    }
}
