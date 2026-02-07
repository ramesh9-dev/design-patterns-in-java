<!-- TOC -->
* [🎯 Strategy Pattern](#-strategy-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Payment Strategy](#-example-payment-strategy)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 🎯 Strategy Pattern

## 📌 Overview

The **Strategy Pattern** is a Behavioral Design Pattern that defines a family of algorithms, encapsulates each one,  
and makes them interchangeable at runtime.

---

## 🎯 Purpose

- Eliminate `if-else` chains
- Allow runtime behavior switching
- Follow Open/Closed Principle
- Improve maintainability

---

## 🧠 When to Use

- Multiple algorithms for same task
- Behavior chosen dynamically
- Want cleaner extensible code

---

## 🏗 Structure

```
Strategy → ConcreteStrategyA, ConcreteStrategyB
Context → uses Strategy
```

---

## 📘 Example: Payment Strategy

Different payment methods handled dynamically without conditionals.

---

## ✅ Complete Java Code (Single Block)

```java
// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

// Concrete Strategy 2
class UPIPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(double amount) {
        strategy.pay(amount);
    }
}

// Client
public class StrategyPatternDemo {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.makePayment(1000);

        context.setStrategy(new UPIPayment());
        context.makePayment(500);
    }
}
```
## 🧩 Key Benefits

- Clean design
- Open for extension
- Runtime flexibility
- Interview favorite pattern

## 🔚 Conclusion

The Strategy Pattern is a powerful tool for managing algorithms and behaviors in a clean, maintainable way.

