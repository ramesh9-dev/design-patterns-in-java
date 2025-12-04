package com.designpatterns.structural.Bridge;

// Abstraction Class
public abstract class Shape {

    // Bridge: Composition with Implementor
    protected Color color;

    // Constructor accepts implementor object
    protected Shape(Color color) {
        this.color = color;
    }

    // Abstract method to be implemented by refined abstractions
    public abstract void draw();

}