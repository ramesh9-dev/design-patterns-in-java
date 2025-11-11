package com.designpatterns.creational.prototype.prototyperegistry;

import com.designpatterns.creational.prototype.Prototype;

// Base Vehicle class
abstract class Vehicle implements Prototype {
    private String model;
    private int price;

    public Vehicle(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle{model='" + model + "', price=" + price + "}";
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

