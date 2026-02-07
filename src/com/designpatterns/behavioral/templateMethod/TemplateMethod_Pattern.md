<!-- TOC -->
* [📐 Template Method Pattern](#-template-method-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Data Processing Workflow](#-example-data-processing-workflow)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 📐 Template Method Pattern

## 📌 Overview

The **Template Method Pattern** defines the skeleton of an algorithm in a base class and allows subclasses to override
specific steps without changing the overall algorithm structure.

---

## 🎯 Purpose

- Define common workflow once
- Let subclasses customize steps
- Avoid code duplication
- Enforce consistent process

---

## 🧠 When to Use

- Algorithm has fixed steps but variable implementations
- Common process across multiple classes
- Want controlled extensibility

---

## 🏗 Structure

```
AbstractClass → templateMethod()
├── step1()
├── step2()
└── step3()

ConcreteClassA
ConcreteClassB
```

---

## 📘 Example: Data Processing Workflow

Steps:

1. Read data
2. Process data
3. Save data

Different formats implement their own logic.

---

## ✅ Complete Java Code (Single Block)

```java
// Abstract Template Class
abstract class DataProcessor {

    // Template method (final to prevent override)
    public final void process() {
        readData();
        processData();
        saveData();
    }

    protected abstract void readData();
    protected abstract void processData();

    protected void saveData() {
        System.out.println("Saving processed data to database");
    }
}

// Concrete Class 1
class CSVDataProcessor extends DataProcessor {

    protected void readData() {
        System.out.println("Reading data from CSV file");
    }

    protected void processData() {
        System.out.println("Processing CSV data");
    }
}

// Concrete Class 2
class XMLDataProcessor extends DataProcessor {

    protected void readData() {
        System.out.println("Reading data from XML file");
    }

    protected void processData() {
        System.out.println("Processing XML data");
    }
}

// Client
public class TemplateMethodDemo {

    public static void main(String[] args) {

        DataProcessor csv = new CSVDataProcessor();
        csv.process();

        System.out.println();

        DataProcessor xml = new XMLDataProcessor();
        xml.process();
    }
}
```
---
## 🧩 Key Benefits
- Reusable algorithm structure
- Controlled customization
- Reduced duplication
- Strong design consistency

## 🔚 Conclusion
Template Method Pattern centralizes workflow logic while allowing flexible step implementation.

Used heavily in:
- Spring JdbcTemplate 
- Hibernate Template APIs 
- Framework lifecycle methods