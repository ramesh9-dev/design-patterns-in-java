<!-- TOC -->
* [🔗 Chain of Responsibility Pattern](#-chain-of-responsibility-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Request Approval System](#-example-request-approval-system)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 🔗 Chain of Responsibility Pattern

## 📌 Overview

The **Chain of Responsibility Pattern** passes a request along a chain of handlers.
Each handler decides either to process the request or pass it to the next handler.

---

## 🎯 Purpose

- Avoid tight coupling between sender & receiver
- Allow multiple handlers for same request
- Follow Open/Closed Principle
- Build flexible processing pipelines

---

## 🧠 When to Use

- Multiple objects can handle a request
- Processing order matters
- You want to remove huge conditional blocks

---

## 🏗 Structure

```
Handler → setNext()
ConcreteHandler1
ConcreteHandler2
ConcreteHandler3
```

---

## 📘 Example: Request Approval System

Request goes through:

Team Lead → Manager → Director

until someone approves it.

---

## ✅ Complete Java Code (Single Block)

```java
// Handler abstract class
abstract class Approver {

    protected Approver next;

    public void setNext(Approver next) {
        this.next = next;
    }

    public abstract void approve(int amount);
}

// Concrete Handler 1
class TeamLead extends Approver {

    public void approve(int amount) {
        if (amount <= 1000) {
            System.out.println("Team Lead approved amount: " + amount);
        } else if (next != null) {
            next.approve(amount);
        }
    }
}

// Concrete Handler 2
class Manager extends Approver {

    public void approve(int amount) {
        if (amount <= 5000) {
            System.out.println("Manager approved amount: " + amount);
        } else if (next != null) {
            next.approve(amount);
        }
    }
}

// Concrete Handler 3
class Director extends Approver {

    public void approve(int amount) {
        if (amount <= 20000) {
            System.out.println("Director approved amount: " + amount);
        } else {
            System.out.println("Amount " + amount + " requires board approval");
        }
    }
}

// Client
public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {

        Approver teamLead = new TeamLead();
        Approver manager = new Manager();
        Approver director = new Director();

        teamLead.setNext(manager);
        manager.setNext(director);

        teamLead.approve(800);
        teamLead.approve(3000);
        teamLead.approve(15000);
        teamLead.approve(50000);
    }
}
```
---
## 🧩 Key Benefits
- Removes large conditional logic
- Flexible request processing
- Easy to extend new handlers
- Clean separation of responsibilities

---
## 🔚 Conclusion
Chain of Responsibility creates processing pipelines where each handler focuses on a single responsibility.

Widely used in:

- Spring Security filter chain
- Servlet filters
- Logging frameworks
- Validation pipelines