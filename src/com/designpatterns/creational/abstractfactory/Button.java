package com.designpatterns.creational.abstractfactory;

// Abstract Product A
interface Button {
    void render();
}


// Concrete Product A1
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

// Concrete Product A2
class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}