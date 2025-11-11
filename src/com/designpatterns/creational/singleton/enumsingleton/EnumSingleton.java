package com.designpatterns.creational.singleton.enumsingleton;

// Enum Singleton Example
public enum EnumSingleton {

    INSTANCE;  // The single instance of the Singleton

    // Example field
    private int counter = 0;

    // Example method
    public void showMessage() {
        System.out.println("Hello from Enum Singleton!");
    }

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
