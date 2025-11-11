# 🏭 Factory Method Pattern

## 📘 Definition
The **Factory Method Pattern** is a creational design pattern that provides an interface for creating objects, but allows subclasses to alter the type of objects that will be created.  
It helps delegate the instantiation logic to subclasses instead of calling the `new` operator directly.

---

## 🎯 Intent
- Define an interface for creating an object, but let subclasses decide which class to instantiate.
- Decouples object creation from its usage.

---

## ⚙️ Structure

```
Creator
 ├── factoryMethod() : Product
 │
 └── someOperation() – uses factoryMethod()

ConcreteCreator
 └── factoryMethod() : ConcreteProduct

Product
ConcreteProduct
```

**Components:**
- **Creator**: Declares the factory method that returns `Product`
- **ConcreteCreator**: Overrides factory method to return `ConcreteProduct`
- **Product**: Defines the interface for objects the factory method creates
- **ConcreteProduct**: Implements the `Product` interface

## ✅ Advantages
- Promotes loose coupling between client and product classes
- Simplifies adding new products without modifying existing code
- Encapsulates object creation logic
- Simplifies extension : you can introduce new product types without changing existing code (follows the Open/Closed Principle).

---

## ⚠️ Disadvantages
- Increases the number of classes in the project
- May add unnecessary complexity compared to direct instantiation

---

## 🧠 When to Use
- When a class cannot anticipate the type of object it must create
- When subclasses should specify the objects they create
- When you want to decouple creation logic from business logic

---

## 🧾 Real-world Examples
- **Java Collections API:** `List.of()`, `Map.of()`
- **JDBC:** `DriverManager.getConnection()`
- **Spring Framework:** Bean Factory pattern
