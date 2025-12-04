package com.designpatterns.structural.Bridge;

// Concrete Implementor 2
public class BlueColor implements Color {
    @Override
    public String fill() {
        return "Filled with Blue color";
    }
}