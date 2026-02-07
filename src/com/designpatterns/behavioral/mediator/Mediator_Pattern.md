<!-- TOC -->
* [🤝 Mediator Pattern](#-mediator-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Chat Room System](#-example-chat-room-system)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 🤝 Mediator Pattern

## 📌 Overview

The **Mediator Pattern** defines an object that encapsulates how a set of objects interact.
It promotes loose coupling by preventing objects from referring to each other explicitly.

---

## 🎯 Purpose

- Reduce direct dependencies
- Centralize communication logic
- Simplify object interactions
- Improve maintainability

---

## 🧠 When to Use

- Many objects communicate with each other
- Complex interaction logic
- Want loose coupling

---

## 🏗 Structure

```
Mediator → notify()
ConcreteMediator
Colleague → communicate via mediator
```


---

## 📘 Example: Chat Room System

Users send messages via a chat room instead of directly messaging each other.

---

## ✅ Complete Java Code (Single Block)

```java
import java.util.*;

// Mediator Interface
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

// Colleague Abstract Class
abstract class User {

    protected ChatMediator mediator;
    protected String name;

    User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String message);
    abstract void receive(String message);
}

// Concrete Colleague
class ChatUser extends User {

    ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    void receive(String message) {
        System.out.println(name + " receives: " + message);
    }
}

// Client
public class MediatorPatternDemo {

    public static void main(String[] args) {

        ChatMediator mediator = new ChatRoom();

        User ramesh = new ChatUser(mediator, "Ramesh");
        User arjun = new ChatUser(mediator, "Arjun");
        User priya = new ChatUser(mediator, "Priya");

        mediator.addUser(ramesh);
        mediator.addUser(arjun);
        mediator.addUser(priya);

        ramesh.send("Hello everyone!");
        arjun.send("Hi Ramesh!");
    }
}
```
---

## 🧩 Key Benefits
- Loose coupling 
- Centralized control 
- Cleaner interactions 
- Easier to scale

---

## 🔚 Conclusion
Mediator Pattern simplifies complex communication by introducing a central coordinator.

Used in:

- Chat systems 
- UI frameworks 
- Workflow coordinators 
- Microservices orchestration