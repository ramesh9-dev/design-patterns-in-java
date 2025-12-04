package com.designpatterns.structural.FlyWeight;

public class Circle implements Shape {

    private final String type = "Circle";  // intrinsic state (shared)

    public Circle() {
        System.out.println("Creating shared Circle object...");
    }

    @Override
    public void draw(int x, int y, String color) {
        System.out.println("Drawing " + type + " at (" + x + "," + y + ") with color " + color);
    }
}