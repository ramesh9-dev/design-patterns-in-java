<!-- TOC -->
* [📢 Command Pattern](#-command-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Remote Control System](#-example-remote-control-system)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 📢 Command Pattern

## 📌 Overview

The **Command Pattern** encapsulates a request as an object, allowing you to parameterize clients with different requests,
queue or log them, and support undo operations.

---

## 🎯 Purpose

- Decouple sender from receiver
- Turn actions into objects
- Support undo/redo
- Enable command queues

---

## 🧠 When to Use

- You want to execute operations dynamically
- Need undo functionality
- Need task scheduling or logging
- Avoid tight coupling

---

## 🏗 Structure

```
Command → execute()
ConcreteCommand
Receiver
Invoker

```

---

## 📘 Example: Remote Control System

Remote sends commands to devices (Light, Fan) without knowing implementation.

---

## ✅ Complete Java Code (Single Block)

```java
// Command Interface
interface Command {
    void execute();
}

// Receiver 1
class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }
}

// Receiver 2
class Fan {
    void start() {
        System.out.println("Fan is running");
    }
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

// Invoker
class RemoteControl {

    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

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
```
---
## 🧩 Key Benefits

- Loose coupling
- Commands can be queued/logged
- Easy to add new commands
- Supports undo patterns

---
## 🔚 Conclusion
Command Pattern turns operations into objects making systems flexible, extensible, and powerful.

Used in:

- Task schedulers 
- Message queues 
- GUI actions 
- Spring batch & job commands