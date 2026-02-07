<!-- TOC -->
* [🔄 State Pattern](#-state-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Order Processing System](#-example-order-processing-system)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 🔄 State Pattern

## 📌 Overview

The **State Pattern** allows an object to change its behavior when its internal state changes.
The object will appear to change its class.

---

## 🎯 Purpose

- Remove complex conditional logic
- Encapsulate state-specific behavior
- Support clean state transitions
- Improve maintainability

---

## 🧠 When to Use

- Object behavior depends on its state
- Many `if-else` or `switch` based on state
- Workflow or lifecycle management

---

## 🏗 Structure

```
State → handle()
ConcreteStateA
ConcreteStateB
Context → holds current State
```

---

## 📘 Example: Order Processing System

Order moves through:

Created → Paid → Shipped → Delivered

Each state controls behavior.

---

## ✅ Complete Java Code (Single Block)

```java
// State Interface
interface OrderState {
    void next(OrderContext context);
    void printStatus();
}

// Context
class OrderContext {
    private OrderState state;

    public OrderContext() {
        state = new CreatedState();
    }

    void setState(OrderState state) {
        this.state = state;
    }

    void next() {
        state.next(this);
    }

    void printStatus() {
        state.printStatus();
    }
}

// Concrete State 1
class CreatedState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new PaidState());
    }

    public void printStatus() {
        System.out.println("Order created");
    }
}

// Concrete State 2
class PaidState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new ShippedState());
    }

    public void printStatus() {
        System.out.println("Order paid");
    }
}

// Concrete State 3
class ShippedState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new DeliveredState());
    }

    public void printStatus() {
        System.out.println("Order shipped");
    }
}

// Concrete State 4
class DeliveredState implements OrderState {

    public void next(OrderContext context) {
        System.out.println("Order already delivered");
    }

    public void printStatus() {
        System.out.println("Order delivered");
    }
}

// Client
public class StatePatternDemo {

    public static void main(String[] args) {

        OrderContext order = new OrderContext();

        order.printStatus();
        order.next();

        order.printStatus();
        order.next();

        order.printStatus();
        order.next();

        order.printStatus();
    }
}
```
---

## 🧩 Key Benefits
- Eliminates state-based conditionals 
- Clean state transitions 
- Highly extensible 
- Perfect for workflows

---
## 🔚 Conclusion
State Pattern models complex workflows cleanly by encapsulating each state’s behavior.

Common in:

- Order/payment systems 
- Workflow engines 
- Microservices saga flows 
- Game engines