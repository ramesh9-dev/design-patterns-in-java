<!-- TOC -->
* [Proxy Design Pattern](#proxy-design-pattern)
  * [✅ Intent](#-intent)
  * [✅ Real-World Examples](#-real-world-examples)
  * [🧱 Types of Proxies](#-types-of-proxies)
  * [📌 UML Diagram (Conceptual)](#-uml-diagram-conceptual)
  * [🧑‍💻 Java Example – Proxy Pattern](#-java-example--proxy-pattern)
  * [✔ Advantages](#-advantages)
  * [❌ Disadvantages](#-disadvantages)
<!-- TOC -->
# Proxy Design Pattern

The Proxy Pattern is a structural design pattern that provides a surrogate or placeholder object that controls access to another object.  
A proxy usually adds additional behavior such as logging, access control, caching, lazy loading, or remote access.

---

## ✅ Intent
- To control access to an object.
- To add extra functionality without modifying the actual object.
- To defer object creation until necessary (lazy loading).

---

## ✅ Real-World Examples
- ATM uses a proxy to validate your card before accessing your bank account.
- Authentication proxy in web applications.
- Hibernate lazy loading proxies.
- API gateways acting as proxies for microservices.

---

## 🧱 Types of Proxies

| Proxy Type               | Purpose                                           |
|--------------------------|---------------------------------------------------|
| Virtual Proxy            | Lazy initialization (creates object when needed). |
| Protection Proxy         | Controls access based on permissions.             |
| Logging/Monitoring Proxy | Logs every method call.                           |
| Remote Proxy             | Manages communication with remote objects.        |
| Caching Proxy            | Stores results and returns cached values.         |

---

## 📌 UML Diagram (Conceptual)
```
Client --> Proxy --> RealSubject --> RealSubject (implements Subject)

```

---

## 🧑‍💻 Java Example – Proxy Pattern

```java
// 1️⃣ Subject Interface
public interface Image {
    void display();
}

// 2️⃣ Real Subject
// This is the real object that is expensive to create
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
        // heavy loading operation
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// 3️⃣ Proxy Class (Lazy Loading)
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // Create object only when needed (Lazy Loading)
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// 4️⃣ Client Code
public class ProxyPatternDemo {
    public static void main(String[] args) {

        Image image = new ProxyImage("pic.jpeg");

        // Image will be loaded only on first display() call
        image.display();  

        System.out.println("---------");

        // This time image will NOT be loaded again
        image.display();  
    }
}

```
---

🧾 Output
```
Loading image from disk: pic.jpeg
Displaying image: pic.jpeg
---------
Displaying image: pic.jpeg
```
## ✔ Advantages
- Lazy initialization improves performance.
- Adds security layers without modifying real object.
- Helps with logging, caching, and monitoring.
- Reduces memory usage.

---

## ❌ Disadvantages
- Adds complexity.
- Introduces additional layers of abstraction.
- Might reduce performance if overused.


