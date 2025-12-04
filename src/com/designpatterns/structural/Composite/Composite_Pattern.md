<!-- TOC -->
* [🌿 Composite Pattern](#-composite-pattern)
  * [📌 Overview](#-overview)
  * [🎯 Purpose](#-purpose)
  * [🧠 When to Use](#-when-to-use)
  * [🏗 Structure](#-structure)
  * [1️⃣ Component Interface — `Employee.java`](#1-component-interface--employeejava)
  * [2️⃣ Leaf Class — `Developer.java`](#2-leaf-class--developerjava)
  * [3️⃣ Another Leaf Class — `Designer.java`](#3-another-leaf-class--designerjava)
  * [4️⃣ Composite Class — `Manager.java`](#4-composite-class--managerjava)
  * [5️⃣ Client Code — `CompositePatternDemo.java`](#5-client-code--compositepatterndemojava)
  * [📝 Output](#-output)
  * [🧩 Key Benefits](#-key-benefits)
  * [⚠️ Drawbacks](#-drawbacks)
  * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 🌿 Composite Pattern

## 📌 Overview
The **Composite Pattern** is a Structural Design Pattern that allows you to treat **individual objects** (Leaf nodes) and **collections of objects** (Composite nodes) uniformly.  
It is commonly used to represent **tree structures** like file systems, UI components, or organizational hierarchies.

---

## 🎯 Purpose
- Represent **part-whole hierarchies**
- Treat leaf and composite objects in the same manner
- Simplify client code (client does not differentiate leaf vs group)
- Build flexible hierarchical structures

---

## 🧠 When to Use
Use the Composite Pattern when:

- You are working with tree-like structures (Folder/File, UI components, Departments/Employees)
- You want to treat individual objects and groups uniformly
- You want to dynamically add/remove hierarchical elements

---

## 🏗 Structure

```
Component
 ├── Leaf
 └── Composite
        └── children : List<Component>
```

---

## 1️⃣ Component Interface — `Employee.java`
```java
public interface Employee {
    void showDetails();
}
```

---

## 2️⃣ Leaf Class — `Developer.java`
```java
public class Developer implements Employee {

    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " - " + position);
    }
}
```

---

## 3️⃣ Another Leaf Class — `Designer.java`
```java
public class Designer implements Employee {

    private String name;
    private String position;

    public Designer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " - " + position);
    }
}
```

---

## 4️⃣ Composite Class — `Manager.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private String name;
    private String position;
    private List<Employee> employees = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employees.remove(emp);
    }

    @Override
    public void showDetails() {
        System.out.println(name + " - " + position);
        System.out.println("Team:");
        for (Employee emp : employees) {
            emp.showDetails();
        }
    }
}
```

---

## 5️⃣ Client Code — `CompositePatternDemo.java`
```java
public class CompositePatternDemo {
    public static void main(String[] args) {

        Employee dev1 = new Developer("Ramesh", "Frontend Developer");
        Employee dev2 = new Developer("Suresh", "Backend Developer");
        Employee designer = new Designer("Mahesh", "UX Designer");

        Manager manager = new Manager("Lokesh", "Project Manager");

        manager.addEmployee(dev1);
        manager.addEmployee(dev2);
        manager.addEmployee(designer);

        manager.showDetails();
    }
}
```

---

## 📝 Output
```
Lokesh - Project Manager
Team:
Ramesh - Frontend Developer
Suresh - Backend Developer
Mahesh - UX Designer
```

---

## 🧩 Key Benefits
- Uniform treatment of leaf and composite
- Easily expandable hierarchy
- Reduces client complexity
- Adds/removes objects at runtime

---

## ⚠️ Drawbacks
- Can make system overly generic
- Hard to restrict composite structure
- Debugging may become difficult due to recursion

---

## 🔚 Conclusion
The **Composite Pattern** helps model hierarchical tree structures and provides a clear and consistent way to treat both individual and composite objects.  
It is heavily used in **UI frameworks, file systems, menus, and org charts**.
