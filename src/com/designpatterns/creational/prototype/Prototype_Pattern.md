# 🧬 Prototype Design Pattern

---

## 📘 Overview
The **Prototype Pattern** is a **creational design pattern** used when the cost of creating an object from scratch is expensive.  
Instead of creating new objects, we **clone** existing ones.  
This pattern is part of the **Gang of Four (GoF)** design patterns.

---

## 🧠 Intent
> “Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.”

In simpler terms:
- You keep a **prototype (template)** object.
- When a new object is needed, you **clone** the existing one instead of instantiating it from scratch.

---

# 🧬 Prototype Design Pattern – Types
- 🧩 **Shallow Copy Prototype**
- 🧬 **Deep Copy Prototype**
- 📚 **Prototype Registry**

---

## 🧩 1. Shallow Copy Prototype

### 🔹 Concept
In a **shallow copy**, a new object is created, but **its fields referencing other objects are not cloned**.  
They still point to the same memory locations as the original object.

### 🔹 Characteristics
- Copies primitive fields (like `int`, `boolean`, `String` literals).
- References (like objects, arrays, collections) are **shared** between the clone and original.
- Any change in the nested object affects both.

### 🔹 Use Case
✅ When the object structure is simple and contains mostly immutable data.  
❌ Not suitable if objects have nested mutable references.

---

## 🧬 2. Deep Copy Prototype

### 🔹 Concept
In a **deep copy**, not only the object itself but also all the **objects it references are recursively cloned**.  
This results in a completely independent clone.

### 🔹 Characteristics
- Clones both primitive and referenced fields.
- Each clone is **independent** of the original.
- More **memory intensive** and **slower**, but safer for mutable objects.

### 🔹 Use Case
✅ When the object has nested mutable fields or complex object graphs.  
❌ Avoid if performance and memory usage are a concern for simple objects.

---

## 📚 3. Prototype Registry

### 🔹 Concept
The **Prototype Registry** maintains a **collection (registry)** of prototype instances.  
Instead of creating new objects directly, clients **request clones** from this registry.

### 🔹 Characteristics
- Promotes **loose coupling** between client and concrete classes.
- Supports **runtime configuration** by adding/removing prototypes dynamically.
- Helps manage different prototype types from a centralized place.

### 🔹 Use Case
✅ When system needs different types of prototypes (e.g., multiple document templates, shapes).  
✅ When object creation logic must be hidden from clients.

---

## 🧾 Comparison Table

| Prototype Type | Description | Independence | Suitable For |
|----------------|-------------|---------------|--------------|
| **Shallow Copy** | Creates a clone with shared references | ❌ No | Simple, immutable objects |
| **Deep Copy** | Creates a completely independent clone | ✅ Yes | Complex objects with nested references |
| **Registry** | Stores predefined prototypes for cloning | ✅ Yes | Systems needing multiple prototype variations |

---

## 🧠 Real-world Analogy
- **Shallow Copy:** Copying a document that still links to the same online image file.
- **Deep Copy:** Copying both the document and the image itself locally.
- **Registry:** Having a folder of reusable document templates to clone when needed.

---

## ✅ Advantages
- Reduces the cost and complexity of creating new objects.
- Hides concrete class instantiation from clients.
- Supports dynamic and flexible object creation.
- Useful when many similar objects are required.

---

## ❌ Disadvantages
- Deep copy can be **complex** for objects with circular references.
- Maintaining the prototype registry requires care.
- Cloning logic can become **error-prone** in large hierarchies.

---

## 🧭 When to Use
- When creating an object is costly (e.g., requires database access or heavy computation).
- When system frequently needs similar objects.
- When you want to **decouple object creation logic** from the client code.

---

## 🏁 Summary
| Type | Key Focus | Independence | Common Use |
|------|------------|---------------|-------------|
| Shallow Copy | Fast, shared references | ❌ | Simple structures |
| Deep Copy | Full duplication | ✅ | Complex nested objects |
| Prototype Registry | Centralized management | ✅ | Multiple prototypes |

---



