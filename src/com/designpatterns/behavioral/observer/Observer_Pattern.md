<!-- TOC -->
* [👀 Observer Pattern](#-observer-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Weather Notification System](#-example-weather-notification-system)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 👀 Observer Pattern

## 📌 Overview

The **Observer Pattern** is a Behavioral Design Pattern where an object (Subject) maintains a list of dependents
(Observers) and notifies them automatically when its state changes.

---

## 🎯 Purpose

- Establish one-to-many dependency
- Auto notification of changes
- Loose coupling between objects
- Common in event-driven systems

---

## 🧠 When to Use

- Multiple objects depend on one object’s state
- Event handling systems
- Real-time updates (notifications, dashboards, listeners)

---

## 🏗 Structure
```
Subject → register(), remove(), notify()
Observer → update()
ConcreteSubject
ConcreteObserver
```


---

## 📘 Example: Weather Notification System

When temperature changes, all subscribed devices get notified.

---

## ✅ Complete Java Code (Single Block)

```java
import java.util.*;

// Observer Interface
interface Observer {
    void update(int temperature);
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Concrete Observer 1
class MobileDisplay implements Observer {

    public void update(int temperature) {
        System.out.println("Mobile Display: Temperature updated to " + temperature + "°C");
    }
}

// Concrete Observer 2
class TVDisplay implements Observer {

    public void update(int temperature) {
        System.out.println("TV Display: Temperature updated to " + temperature + "°C");
    }
}

// Client
public class ObserverPatternDemo {

    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        Observer mobile = new MobileDisplay();
        Observer tv = new TVDisplay();

        station.addObserver(mobile);
        station.addObserver(tv);

        station.setTemperature(30);
        station.setTemperature(35);
    }
}
```

---
## 🧩 Key Benefits   
- Loose coupling 
- Automatic updates
- Easy to add new observers
- Great for event systems

---
## 🔚 Conclusion 
The Observer Pattern is essential for building flexible, maintainable, and scalable applications where multiple components need to react to changes in state. It promotes loose coupling and enhances the modularity of the system.