package com.designpatterns.structural.Bridge;

// Concrete Implementor 1
public class RedColor implements Color {
    @Override
    public String fill() {
        return "Filled with Red color";
    }
}