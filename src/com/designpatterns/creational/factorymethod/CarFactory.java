package com.designpatterns.creational.factorymethod;

public class CarFactory {

    // Factory method
    public static Car getCar(String type) {
        if (type == null) {
            return null;
        }
        switch (type.toUpperCase()) {
            case "SEDAN":
                return new Sedan();
            case "SUV":
                return new SUV();
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}
