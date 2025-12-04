package com.designpatterns.structural.Bridge;

// Refined Abstraction 2
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Square drawn -> " + color.fill());
    }
}