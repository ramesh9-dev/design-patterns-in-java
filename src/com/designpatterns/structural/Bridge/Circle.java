package com.designpatterns.structural.Bridge;

// Refined Abstraction 1
public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Circle drawn -> " + color.fill());
    }
}