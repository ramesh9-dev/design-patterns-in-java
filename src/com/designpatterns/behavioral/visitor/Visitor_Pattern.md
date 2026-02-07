<!-- TOC -->
* [🧭 Visitor Pattern](#-visitor-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Shopping Cart System](#-example-shopping-cart-system)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 🧭 Visitor Pattern

## 📌 Overview

The **Visitor Pattern** lets you define new operations on a group of objects without changing their classes.
It separates algorithms from the object structure.

---

## 🎯 Purpose

- Add new behavior without modifying existing classes
- Follow Open/Closed Principle
- Centralize operations logic
- Improve maintainability

---

## 🧠 When to Use

- Stable object structure but changing operations
- Need multiple unrelated operations
- Want clean separation of logic

---

## 🏗 Structure

```
Visitor → visit(ElementA), visit(ElementB)
ConcreteVisitor
Element → accept(Visitor)
ConcreteElement
```


---

## 📘 Example: Shopping Cart System

Calculate total price for different product types using visitor.

---

## ✅ Complete Java Code (Single Block)

```java
// Visitor Interface
interface ShoppingCartVisitor {
    double visit(Book book);
    double visit(Electronics electronics);
}

// Element Interface
interface Item {
    double accept(ShoppingCartVisitor visitor);
}

// Concrete Element 1
class Book implements Item {

    private double price;

    Book(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

// Concrete Element 2
class Electronics implements Item {

    private double price;

    Electronics(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

// Concrete Visitor
class PriceCalculatorVisitor implements ShoppingCartVisitor {

    public double visit(Book book) {
        return book.getPrice() * 0.9; // 10% discount
    }

    public double visit(Electronics electronics) {
        return electronics.getPrice() * 1.18; // tax added
    }
}

// Client
public class VisitorPatternDemo {

    public static void main(String[] args) {

        Item[] items = {
            new Book(500),
            new Electronics(2000)
        };

        ShoppingCartVisitor visitor = new PriceCalculatorVisitor();

        double total = 0;
        for (Item item : items) {
            total += item.accept(visitor);
        }

        System.out.println("Total cost = " + total);
    }
}
```
---
## 🧩 Key Benefits
- Add new operations easily 
- Keeps object classes simple 
- Follows Open/Closed Principle 
- Centralized business logic

---
## 🔚 Conclusion
Visitor Pattern is ideal when object structure is stable but behaviors change frequently.

Used in:

- Compilers (AST traversal)
- Reporting engines 
- Rule engines 
- Data transformation systems