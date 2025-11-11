package com.designpatterns.creational.singleton;

/*
Ensure that a class has only one instance, and provide a global point of access to it

Instance is created only when required.
Saves resources but not thread-safe.
*/
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton(); // Not thread safe
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Lazy Singleton Instance");
    }

    public static void main(String[] args) {
        LazySingleton obj1 = LazySingleton.getInstance();
        LazySingleton obj2 = LazySingleton.getInstance();

        System.out.println(obj1 == obj2);
        obj1.showMessage();
    }
}
