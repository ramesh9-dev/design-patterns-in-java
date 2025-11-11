package com.designpatterns.creational.prototype.prototyperegistry;

// Car class
class Car extends Vehicle {
    private int doors;

    public Car(String model, int price, int doors) {
        super(model, price);
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{model='" + getModel() + "', price=" + getPrice() + ", doors=" + doors + "}";
    }
}
