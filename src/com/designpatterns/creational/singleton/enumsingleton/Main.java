package com.designpatterns.creational.singleton.enumsingleton;

public class Main {
    public static void main(String[] args) {
        // Get the single instance
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        singleton1.showMessage();
        singleton1.increment();

        System.out.println("Counter from singleton2: " + singleton2.getCounter());

        // Verify both references point to same instance
        System.out.println(singleton1 == singleton2);  // true
    }
}
