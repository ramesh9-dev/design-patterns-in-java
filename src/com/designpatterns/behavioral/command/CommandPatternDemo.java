package com.designpatterns.behavioral.command;

// Client
public class CommandPatternDemo {

    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();

        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        remote.setCommand(new FanStartCommand(fan));
        remote.pressButton();
    }
}