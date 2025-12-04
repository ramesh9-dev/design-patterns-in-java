<!-- TOC -->
* [🌉 Bridge Pattern](#-bridge-pattern)
  * [📌 Overview](#-overview)
  * [🎯 Purpose](#-purpose)
  * [🧠 When to Use](#-when-to-use)
  * [🏗 Structure](#-structure)
    * [Components](#components)
  * [📘 Example: Shape & Color](#-example-shape--color)
  * [✅ Java Example](#-java-example)
    * [1️⃣ Implementor Interface — `Color.java`](#1-implementor-interface--colorjava)
    * [2️⃣ Concrete Implementors — `Red.java` and `Blue.java`](#2-concrete-implementors--redjava-and-bluejava)
    * [3️⃣ Abstraction — `Shape.java`](#3-abstraction--shapejava)
    * [4️⃣ Refined Abstractions — `Circle.java` and `Square.java`](#4-refined-abstractions--circlejava-and-squarejava)
    * [5️⃣ Client Code — `BridgePatternDemo.java`](#5-client-code--bridgepatterndemojava)
  * [🧩 Key Benefits](#-key-benefits)
  * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 🌉 Bridge Pattern

## 📌 Overview

The **Bridge Pattern** is a Structural Design Pattern that separates an abstraction from its implementation, allowing
both to evolve independently.  
This avoids subclass explosion when a class has multiple dimensions of variation.

---

## 🎯 Purpose

- Decouple abstraction from implementation
- Allow switching implementations at runtime
- Avoid subclass explosion
- Improve flexibility, scalability, and maintainability

---

## 🧠 When to Use

Use the Bridge Pattern when:

- A class has multiple varying dimensions (e.g., Shape + Color)
- You want to avoid classes like `RedCircle`, `BlueCircle`, `RedSquare`
- You need dynamic runtime switching of implementations
- You want cleaner architecture by separating responsibilities

---

## 🏗 Structure

    Abstraction
     └── RefinedAbstraction
    Implementor
     └── ConcreteImplementorA
     └── ConcreteImplementorB

### Components

- **Abstraction** – High-level control layer (Example: Shape)
- **Implementor** – Low-level operational interface (Example: Color)
- **RefinedAbstraction** – Concrete abstractions (Circle, Square)
- **ConcreteImplementor** – Implementor implementations (Red, Blue)

---

## 📘 Example: Shape & Color

We have two independent hierarchies:

- Shapes → Circle, Square
- Colors → Red, Blue

Bridge lets us mix them without creating multiple subclasses like `RedCircle`, `BlueCircle`, etc.

---

## ✅ Java Example

### 1️⃣ Implementor Interface — `Color.java`

```java
// Implementor interface
public interface Color {
    String fill();
}
```

### 2️⃣ Concrete Implementors — `Red.java` and `Blue.java`

```java
// Concrete Implementor 1
public class RedColor implements Color {
    @Override
    public String fill() {
        return "Filled with Red color";
    }
}

// Concrete Implementor 2
public class BlueColor implements Color {
    @Override
    public String fill() {
        return "Filled with Blue color";
    }
}
```

### 3️⃣ Abstraction — `Shape.java`

```java
// Abstraction Class
public abstract class Shape {

    // Bridge: Composition with Implementor
    protected Color color;

    // Constructor accepts implementor object
    protected Shape(Color color) {
        this.color = color;
    }

    // Abstract method to be implemented by refined abstractions
    public abstract void draw();
}
```

### 4️⃣ Refined Abstractions — `Circle.java` and `Square.java`

```java
// Refined Abstraction 1
public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Circle drawn -> " + color.fill());
    }
}

// Refined Abstraction 2
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Square drawn -> " + color.fill());
    }
}
```

### 5️⃣ Client Code — `BridgePatternDemo.java`

```java
public class BridgePatternDemo {
    public static void main(String[] args) {

        Shape redCircle = new Circle(new RedColor());
        redCircle.draw();

        Shape blueSquare = new Square(new BlueColor());
        blueSquare.draw();
    }
}
```
---
## 🧩 Key Benefits

- Clean separation between abstraction & implementation
- Avoids explosive growth of subclasses
- Easier extension (add new shapes or colors independently)
- Implementation can be swapped at runtime

## 🔚 Conclusion

The Bridge Pattern provides great flexibility by separating abstraction from implementation.
It is ideal for avoiding subclass explosion when you have multiple independent dimensions of variation.