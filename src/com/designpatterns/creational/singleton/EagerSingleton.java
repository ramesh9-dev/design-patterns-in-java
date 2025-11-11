package com.designpatterns.creational.singleton;

/*
Ensure that a class has only one instance, and provide a global point of access to it

Instance is created at class loading time.
Simple and thread-safe by default.
But if the instance is never used, it wastes memory.
*/
public class EagerSingleton {

    // Instance is created as soon as the class is loaded
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Eager Singleton Instance");
    }

    public static void main(String[] args) {
        EagerSingleton obj1 = EagerSingleton.getInstance();
        EagerSingleton obj2 = EagerSingleton.getInstance();

        System.out.println(obj1 == obj2);
        obj1.showMessage();
    }
}