package com.designpatterns.creational.singleton;

/*
Ensure that a class has only one instance, and provide a global point of access to it

Synchronize the entire getInstance() method.
Makes it thread-safe but adds performance overhead.

*/
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Thread Safe Singleton Instance");
    }

    public static void main(String[] args) {
        ThreadSafeSingleton obj1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton obj2 = ThreadSafeSingleton.getInstance();

        System.out.println(obj1 == obj2);
        obj1.showMessage();
    }
}
