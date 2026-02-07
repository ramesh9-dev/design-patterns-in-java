package com.designpatterns.behavioral.observer;

// Concrete Observer 1
class MobileDisplay implements Observer {

    public void update(int temperature) {
        System.out.println("Mobile Display: Temperature updated to " + temperature + "°C");
    }
}
