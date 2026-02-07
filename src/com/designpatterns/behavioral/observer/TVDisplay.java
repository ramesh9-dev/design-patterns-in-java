package com.designpatterns.behavioral.observer;

// Concrete Observer 2
class TVDisplay implements Observer {

    public void update(int temperature) {
        System.out.println("TV Display: Temperature updated to " + temperature + "°C");
    }
}