package com.designpatterns.behavioral.command;

// Command Interface
interface Command {
    void execute();
}

// Concrete Command 1
class LightOnCommand implements Command {

    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Concrete Command 2
class FanStartCommand implements Command {

    private Fan fan;

    FanStartCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.start();
    }
}