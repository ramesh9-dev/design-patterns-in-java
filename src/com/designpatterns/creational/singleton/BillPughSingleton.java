package com.designpatterns.creational.singleton;

/*
Ensure that a class has only one instance, and provide a global point of access to it

Uses static inner helper class.
Thread-safe without synchronization overhead.
*/
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    // Inner static helper class is loaded only when getInstance() is called
    private static class Helper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Helper.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Bill Pugh Singleton Instance");
    }

    public static void main(String[] args) {
        BillPughSingleton obj1 = BillPughSingleton.getInstance();
        BillPughSingleton obj2 = BillPughSingleton.getInstance();

        System.out.println(obj1 == obj2);
        obj1.showMessage();
    }
}
