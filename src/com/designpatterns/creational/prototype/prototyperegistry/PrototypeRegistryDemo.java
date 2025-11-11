package com.designpatterns.creational.prototype.prototyperegistry;

public class PrototypeRegistryDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle car1 = VehicleRegistry.getVehicle("basicCar");
        Vehicle car2 = VehicleRegistry.getVehicle("basicCar");
        // modify clone
        car2.setPrice(850000);

        Vehicle bike1 = VehicleRegistry.getVehicle("mountainBike");

        System.out.println("car1: " + car1);
        System.out.println("car2: " + car2);
        System.out.println("bike1: " + bike1);
    }
}
