<!-- TOC -->
* [Decorator Pattern (Structural Design Pattern)](#decorator-pattern-structural-design-pattern)
  * [🔥 Why Use the Decorator Pattern?](#-why-use-the-decorator-pattern)
  * [🧠 Real-Life Analogy](#-real-life-analogy)
* [📌 Structure](#-structure)
* [✅ Java Implementation of Decorator Pattern](#-java-implementation-of-decorator-pattern)
  * [1️⃣ Component Interface](#1-component-interface)
  * [2️⃣ Concrete Component](#2-concrete-component)
  * [3️⃣ Decorator (Base Wrapper Class)](#3-decorator-base-wrapper-class)
  * [4️⃣ Concrete Decorators](#4-concrete-decorators)
    * [☕ Add Milk](#-add-milk)
    * [🍫 Add Chocolate](#-add-chocolate)
  * [5️⃣ Client Code](#5-client-code)
  * [🎯 Output](#-output)
* [✔ Advantages](#-advantages)
* [❌ Disadvantages](#-disadvantages)
* [🎉 Summary](#-summary)
<!-- TOC -->

# Decorator Pattern (Structural Design Pattern)

The **Decorator Pattern** is a structural design pattern that allows you to **add new functionality to an object dynamically**, without modifying its original code.  
It wraps the original object inside another object, known as the **decorator**, which adds new behavior before/after delegating the call.

---

## 🔥 Why Use the Decorator Pattern?

- Add responsibilities dynamically at runtime.
- Avoid subclass explosion.
- Follow **Open-Closed Principle** (extend without modifying existing code).
- Add behavior without touching the base class.

---

## 🧠 Real-Life Analogy

Think of customizing a coffee:

- Start with **Basic Coffee**
- Add **Milk**
- Add **Chocolate**
- Add **Whipped Cream**

Each topping decorates the original coffee with extra features and cost.

---

# 📌 Structure

```
Component
    ↑
ConcreteComponent
    ↑
Decorator (abstract)
    ↑
ConcreteDecorator(s)
```

- **Component** → Interface or abstract class defining operations.
- **ConcreteComponent** → Base object.
- **Decorator** → Base wrapper that holds reference to Component.
- **ConcreteDecorator** → Adds extra behavior.

---

# ✅ Java Implementation of Decorator Pattern

## 1️⃣ Component Interface

```java
public interface Coffee {
    String getDescription();
    double getCost();
}
```

---

## 2️⃣ Concrete Component

```java
public class BasicCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 50.0;
    }
}
```

---

## 3️⃣ Decorator (Base Wrapper Class)

```java
public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;  // Composition: HAS-A relationship

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}
```

---

## 4️⃣ Concrete Decorators

### ☕ Add Milk

```java
public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.0;
    }
}
```

### 🍫 Add Chocolate

```java
public class ChocolateDecorator extends CoffeeDecorator {

    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chocolate";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20.0;
    }
}
```

---

## 5️⃣ Client Code

```java
public class DecoratorDemo {
    public static void main(String[] args) {

        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " : " + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " : " + coffee.getCost());

        coffee = new ChocolateDecorator(coffee);
        System.out.println(coffee.getDescription() + " : " + coffee.getCost());
    }
}
```

---

## 🎯 Output

```
Basic Coffee : 50.0
Basic Coffee, Milk : 60.0
Basic Coffee, Milk, Chocolate : 80.0
```

---

# ✔ Advantages

- Add behavior dynamically.
- Uses **composition**, not inheritance.
- Cleaner and more flexible than subclassing.

---

# ❌ Disadvantages

- Too many small objects can make debugging harder.
- Can become complex when multiple decorators are used.

---

# 🎉 Summary

| Aspect | Details |
|--------|---------|
| **Pattern Type** | Structural |
| **Purpose** | Add new behavior without modifying original class |
| **Key Principle** | Composition over inheritance |
| **Used in Java** | I/O Streams (e.g., BufferedInputStream) |

---
