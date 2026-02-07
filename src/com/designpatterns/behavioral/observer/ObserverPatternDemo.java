package com.designpatterns.behavioral.observer;

// Client
public class ObserverPatternDemo {

    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        Observer mobile = new MobileDisplay();
        Observer tv = new TVDisplay();

        station.addObserver(mobile);
        station.addObserver(tv);

        station.setTemperature(30);
        station.removeObserver(mobile);
        station.setTemperature(35);
    }
}