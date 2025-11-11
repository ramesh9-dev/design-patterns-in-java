package com.designpatterns.creational.factorymethod;

public class Main {
    public static void main(String[] args) {
        Car sedan = CarFactory.getCar("sedan");
        sedan.drive();

        Car suv = CarFactory.getCar("suv");
        suv.drive();
    }
}
