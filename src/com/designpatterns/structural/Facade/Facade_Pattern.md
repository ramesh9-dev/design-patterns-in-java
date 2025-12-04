<!-- TOC -->
* [Facade Pattern (Structural Design Pattern)](#facade-pattern-structural-design-pattern)
  * [🎯 **Intent**](#-intent)
  * [🧠 **Real-Life Analogy**](#-real-life-analogy)
  * [📌 **Structure**](#-structure)
* [✅ **Java Implementation**](#-java-implementation)
  * [1️⃣ Subsystem Classes](#1-subsystem-classes)
  * [2️⃣ Facade Class](#2-facade-class)
  * [3️⃣ Client Code](#3-client-code)
  * [🎯 **Output**](#-output)
* [✔ Advantages](#-advantages)
* [❌ Disadvantages](#-disadvantages)
* [🎉 Summary](#-summary)
<!-- TOC -->

# Facade Pattern (Structural Design Pattern)

The **Facade Pattern** provides a simplified, unified interface to a complex subsystem.  
It hides complexity and exposes only what the client needs — making the system easier to use.

---

## 🎯 **Intent**
- Provide a single, easy-to-use interface to a complex system.
- Reduce dependencies between client and subsystem.
- Improve readability and maintainability.

---

## 🧠 **Real-Life Analogy**

Using your **TV remote**:
- Instead of manually controlling internal circuits,
- You use a simple interface: *Power ON*, *Volume Up*, *Channel Change*.

The remote acts as a **Facade**.

---

## 📌 **Structure**

```
Client → Facade → Subsystem A
                     ├── Subsystem B
                     ├── Subsystem C
```

- **Facade** → Provides simple methods.
- **Subsystem classes** → Contain actual complex operations.
- **Client** → Calls facade instead of interacting with subsystems directly.

---

# ✅ **Java Implementation**

## 1️⃣ Subsystem Classes

```java
public class CPU {
    public void freeze() {
        System.out.println("CPU freeze");
    }
    public void jump(long position) {
        System.out.println("CPU jump to " + position);
    }
    public void execute() {
        System.out.println("CPU execute");
    }
}
```

```java
public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Loading data to memory at position " + position);
    }
}
```

```java
public class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("Reading " + size + " bytes from HDD at " + lba);
        return new byte[size];
    }
}
```

---

## 2️⃣ Facade Class

```java
public class ComputerFacade {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void start() {
        System.out.println("Starting computer...");
        cpu.freeze();
        byte[] bootSector = hardDrive.read(0, 1024);
        memory.load(0, bootSector);
        cpu.jump(0);
        cpu.execute();
        System.out.println("Computer started successfully!");
    }
}
```

---

## 3️⃣ Client Code

```java
public class FacadeDemo {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();  // Client interacts with simplified interface
    }
}
```

---

## 🎯 **Output**

```
Starting computer...
CPU freeze
Reading 1024 bytes from HDD at 0
Loading data to memory at position 0
CPU jump to 0
CPU execute
Computer started successfully!
```

---

# ✔ Advantages
- Simplifies complex systems.
- Reduces coupling between client and subsystem.
- Improves maintainability & readability.
- Clients don’t need to understand detailed subsystem operations.

---

# ❌ Disadvantages
- Facade may become a “god object” if overloaded with too many responsibilities.
- Hides functionality — sometimes clients may need full control.

---

# 🎉 Summary

| Aspect | Details |
|--------|---------|
| **Pattern Type** | Structural |
| **Purpose** | Simplify interactions with complex subsystems |
| **Principle** | Encapsulation |
| **Used In** | Spring (JdbcTemplate), JavaMail API, Hibernate SessionFactory |

---
