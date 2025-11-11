# 🧱 Builder Pattern

## 📘 Definition
The **Builder Pattern** is a creational design pattern that lets you construct complex objects step by step.
It separates the construction process from the representation, allowing the same construction process to create different representations.

## ✅ Advantages
- Provides a clear and readable object creation syntax.
- Avoids telescoping constructors.
- Makes it easy to create immutable objects.
- Allows different representations of an object.
- Follows Single Responsibility Principle and Open/Closed Principle.
- Open/Closed Principle: you can add new builders without modifying existing code.

## ⚠️ Disadvantages
- Adds extra boilerplate code (builder classes).
- Can be overkill for simple objects.

## 🧠 When to Use
- When objects have many optional parameters or complex construction logic.
- When you want to create immutable objects.
- When multiple representations of an object need to be created.

## 🧾 Real-world Examples
- StringBuilder / StringBuffer in Java.
- Lombok’s @Builder annotation.
- Spring’s BeanDefinitionBuilder and HttpClientBuilder.