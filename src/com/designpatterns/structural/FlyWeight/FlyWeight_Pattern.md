<!-- TOC -->
* [Flyweight Pattern (Structural Design Pattern)](#flyweight-pattern-structural-design-pattern)
  * [🎯 Intent](#-intent)
  * [🧠 Real-Life Analogy](#-real-life-analogy)
  * [📌 Structure](#-structure)
* [✅ Java Implementation (Flyweight Pattern)](#-java-implementation-flyweight-pattern)
  * [1️⃣ Flyweight Interface](#1-flyweight-interface)
  * [2️⃣ Concrete Flyweight (Shared Object)](#2-concrete-flyweight-shared-object)
  * [3️⃣ Flyweight Factory](#3-flyweight-factory)
  * [4️⃣ Client Code](#4-client-code)
  * [🎯 Output Example](#-output-example)
* [✔ Advantages](#-advantages)
* [❌ Disadvantages](#-disadvantages)
* [🎉 Summary](#-summary)
<!-- TOC -->
    

# Flyweight Pattern (Structural Design Pattern)

The **Flyweight Pattern** is used to minimize memory usage by sharing as much data as possible with similar objects.  
It is useful when a large number of objects must be created and most of their data is shared.

---

## 🎯 Intent
- Reduce memory footprint.
- Reuse shared objects instead of creating new ones.
- Separate **intrinsic state** (shared) and **extrinsic state** (unique per object).

---

## 🧠 Real-Life Analogy

Think of a **text editor**:
- Every letter ('a', 'b', 'c') is stored once (shared).
- Only the position (x, y) differs (external data).

Thus, millions of characters can be rendered efficiently.

---

## 📌 Structure

```
Flyweight (Interface)
   ↑
ConcreteFlyweight (Shared object)

FlyweightFactory
   └── Manages and returns shared instances

Client
   └── Supplies extrinsic (unique) state
```

---

# ✅ Java Implementation (Flyweight Pattern)

## 1️⃣ Flyweight Interface

```java
public interface Shape {
    void draw(int x, int y, String color); // extrinsic state
}
```

---

## 2️⃣ Concrete Flyweight (Shared Object)

```java
public class Circle implements Shape {

    private final String type = "Circle";  // intrinsic state (shared)

    public Circle() {
        System.out.println("Creating shared Circle object...");
    }

    @Override
    public void draw(int x, int y, String color) {
        System.out.println("Drawing " + type + " at (" + x + "," + y + ") with color " + color);
    }
}
```

---

## 3️⃣ Flyweight Factory

```java
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getCircle() {
        String key = "circle";

        if (!shapeMap.containsKey(key)) {
            shapeMap.put(key, new Circle());
        }

        return shapeMap.get(key);
    }
}
```

---

## 4️⃣ Client Code

```java
import java.util.Random;

public class FlyweightDemo {
    public static void main(String[] args) {

        Random random = new Random();
        String[] colors = {"Red", "Blue", "Green", "Yellow"};

        for (int i = 0; i < 5; i++) {
            Shape circle = ShapeFactory.getCircle();  // shared object
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            String color = colors[random.nextInt(colors.length)];

            circle.draw(x, y, color);  // extrinsic state
        }
    }
}
```

---

## 🎯 Output Example

```
Creating shared Circle object...
Drawing Circle at (10,25) with color Red
Drawing Circle at (50,45) with color Yellow
Drawing Circle at (30,90) with color Green
Drawing Circle at (60,15) with color Blue
Drawing Circle at (12,80) with color Red
```

---

# ✔ Advantages
- Huge memory savings.
- Efficient when many similar objects exist.
- Reduces object creation overhead.

---

# ❌ Disadvantages
- Increases complexity due to extrinsic state handling.
- Must ensure objects are truly shareable.
- Debugging can get harder.

---

# 🎉 Summary

| Aspect | Details |
|--------|---------|
| **Pattern Type** | Structural |
| **Purpose** | Minimize memory by sharing objects |
| **State Handling** | Intrinsic (shared) + Extrinsic (client-provided) |
| **Used In** | Java String Pool, Integer Cache, GUI libraries |

---
