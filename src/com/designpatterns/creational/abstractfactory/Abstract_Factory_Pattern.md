# 🏗 Abstract Factory Pattern

## 📘 Definition
The **Abstract Factory Pattern** provides an interface for creating families of related or dependent objects **without specifying their concrete classes**.
It is also known as a **Factory of Factories**, since it produces multiple factories that generate related objects.

---

## 🎯 Intent
- Provide an interface to create families of related objects.
- Ensure that products created together are compatible.
- Make client code independent of concrete product classes.

---

## ⚙️ Structure

```
AbstractFactory
 ├── createProductA()
 └── createProductB()
 
ConcreteFactory1
 ├── createProductA() → ProductA1
 └── createProductB() → ProductB1

ConcreteFactory2
 ├── createProductA() → ProductA2
 └── createProductB() → ProductB2

AbstractProductA
ConcreteProductA1
ConcreteProductA2

AbstractProductB
ConcreteProductB1
ConcreteProductB2

Client
 └── Uses AbstractFactory and Products
```

---

## 💻 Java Example

```java
// Abstract Product A
interface Button {
    void render();
}

// Abstract Product B
interface Checkbox {
    void check();
}

// Concrete Product A1
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

// Concrete Product A2
class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

// Concrete Product B1
class WindowsCheckbox implements Checkbox {
    public void check() {
        System.out.println("Checking Windows Checkbox");
    }
}

// Concrete Product B2
class MacCheckbox implements Checkbox {
    public void check() {
        System.out.println("Checking Mac Checkbox");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory 1
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory 2
class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory factory;

        String osName = "Windows"; // Example input
        if (osName.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.check();
    }
}
```

---

## ✅ Advantages
- Follows the **Open/Closed Principle** — add new product families without changing existing code.
- Promotes **consistency** among related products.
- Provides **loose coupling** between client and product implementations.
- Simplifies **object creation** for systems that support multiple product variants.

---

## ⚠️ Disadvantages
- Increases **complexity** due to multiple layers of abstraction.
- Difficult to introduce new product types without altering factory interfaces.

---

## 🧠 When to Use
- When you need to create **families of related or dependent objects**.
- When products must be **compatible** with each other.
- When your application should be **independent of how its products are created**.

---

## 🧾 Real-world Examples
- **Java AWT/Swing UI toolkit**: Different look and feel (Windows, Mac, Linux).
- **JDBC DriverManager**: Creates database-specific connection objects.
- **Spring ApplicationContext**: Acts as a factory that manages bean creation.
