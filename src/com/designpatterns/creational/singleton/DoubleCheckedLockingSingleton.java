package com.designpatterns.creational.singleton;

/*
Ensure that a class has only one instance, and provide a global point of access to it

Checks twice before creating the instance.
Uses synchronization only when needed (on first call).
Efficient and thread-safe
*/
public class DoubleCheckedLockingSingleton {

    /*
    volatile ensures visibility and ordering.
    It tells the JVM and CPU:
    “Don’t reorder writes or reads to this variable across threads.”
    */
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // 1st check (no locking)
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // 2nd check (with lock)
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Double Checked Locking Singleton Instance");
    }

    public static void main(String[] args) {
        DoubleCheckedLockingSingleton obj1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton obj2 = DoubleCheckedLockingSingleton.getInstance();

        System.out.println(obj1 == obj2);
        obj1.showMessage();
    }
}
