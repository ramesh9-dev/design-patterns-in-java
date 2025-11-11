package com.designpatterns.creational.abstractfactory;

// Abstract Product B
interface Checkbox {
    void check();
}

// Concrete Product B1
class WindowsCheckbox implements Checkbox {
    public void check() {
        System.out.println("Checking Windows Checkbox");
    }
}

// Concrete Product B2
class MacCheckbox implements Checkbox {
    public void check() {
        System.out.println("Checking Mac Checkbox");
    }
}