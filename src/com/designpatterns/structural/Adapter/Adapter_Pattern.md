<!-- TOC -->
* [🔌 Adapter Pattern](#-adapter-pattern)
  * [📘 Definition](#-definition)
  * [🎯 Intent](#-intent)
  * [⚙️ Structure](#-structure)
  * [✅ Advantages](#-advantages)
  * [⚠️ Disadvantages](#-disadvantages)
  * [🧠 When to Use](#-when-to-use)
  * [🧾 Real-world Examples](#-real-world-examples)
  * [💻 Example Code (Java)](#-example-code-java)
    * [Target Interface](#target-interface)
    * [Adaptee](#adaptee)
    * [Adapter](#adapter)
    * [Client](#client)
  * [🧩 Summary](#-summary)
<!-- TOC -->


# 🔌 Adapter Pattern

## 📘 Definition

The **Adapter Pattern** is a structural design pattern that allows
incompatible interfaces to work together.\
It acts as a wrapper that converts the interface of an existing class
(Adaptee) into one expected by the Client (Target).

------------------------------------------------------------------------

## 🎯 Intent

-   Convert one interface into another interface expected by the client\
-   Allow integration of legacy or third-party classes without modifying
    them\
-   Promote reusability by adapting existing implementations

------------------------------------------------------------------------

## ⚙️ Structure

    Client
     └── uses Target

    Target (interface)
     └── request()

    Adapter
     ├── adaptee : Adaptee
     └── request() → translates call to Adaptee.specificRequest()

    Adaptee
     └── specificRequest() – existing incompatible method

**Components:** - **Target**: Interface expected by the client\
- **Adaptee**: Existing class with incompatible interface\
- **Adapter**: Converts calls from `Target` to `Adaptee`\
- **Client**: Works with `Target` and remains unaware of adaptation

------------------------------------------------------------------------

## ✅ Advantages

-   Allows reuse of existing/legacy code\
-   Follows **Open/Closed Principle** (no modification to Adaptee)\
-   Improves flexibility by separating conversion logic\
-   Client code remains clean and decoupled

------------------------------------------------------------------------

## ⚠️ Disadvantages

-   Introduces extra layers (slightly more complexity)\
-   Too many adapters can make code harder to understand

------------------------------------------------------------------------

## 🧠 When to Use

-   When an existing class does the job but its interface is
    incompatible\
-   When integrating third-party libraries\
-   When migrating from legacy systems (e.g., XML → JSON services)\
-   When you want to avoid modifying tested, stable code

------------------------------------------------------------------------

## 🧾 Real-world Examples

-   **Java I/O Streams**: `InputStreamReader` adapts `InputStream` to
    `Reader`\
-   **Collections Framework**: `Arrays.asList()` adapts arrays to
    `List`\
-   **Spring MVC**: `HandlerAdapter` allows various controller types

------------------------------------------------------------------------

## 💻 Example Code (Java)

### Target Interface

``` java
public interface JsonService {
    String getJson();
}
```

### Adaptee

``` java
public class XmlService {
    public String getXml() {
        return "<message>Hello from XML</message>";
    }
}
```

### Adapter

``` java
public class XmlToJsonAdapter implements JsonService {

    private XmlService xmlService;

    public XmlToJsonAdapter(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public String getJson() {
        String xml = xmlService.getXml();
        return "{ "message": "Converted from XML" }";
    }
}
```

### Client

``` java
public class AdapterPatternDemo {
    public static void main(String[] args) {
        JsonService jsonService = new XmlToJsonAdapter(new XmlService());
        System.out.println(jsonService.getJson());
    }
}
```

------------------------------------------------------------------------

## 🧩 Summary

The Adapter Pattern enables the integration of incompatible systems
without changing existing code.\
It works by wrapping an existing class with a new interface, making the
entire system more flexible and maintainable.
