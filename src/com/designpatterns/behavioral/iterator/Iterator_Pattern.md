<!-- TOC -->
* [📚 Iterator Pattern](#-iterator-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Book Collection](#-example-book-collection)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 📚 Iterator Pattern

## 📌 Overview

The **Iterator Pattern** provides a way to access elements of a collection sequentially
without exposing its internal structure.

---

## 🎯 Purpose

- Traverse collections uniformly
- Hide internal data structure
- Support multiple traversal strategies
- Improve encapsulation

---

## 🧠 When to Use

- Need sequential access to elements
- Want to hide how collection is implemented
- Want consistent traversal interface

---

## 🏗 Structure

```
Iterator → hasNext(), next()
ConcreteIterator
Aggregate → createIterator()
ConcreteAggregate

```

---

## 📘 Example: Book Collection

Iterate through books without exposing list structure.

---

## ✅ Complete Java Code (Single Block)

```java
import java.util.*;

// Iterator Interface
interface BookIterator {
    boolean hasNext();
    String next();
}

// Aggregate Interface
interface BookCollection {
    BookIterator createIterator();
}

// Concrete Collection
class Library implements BookCollection {

    private List<String> books = new ArrayList<>();

    public void addBook(String book) {
        books.add(book);
    }

    public BookIterator createIterator() {
        return new LibraryIterator();
    }

    // Concrete Iterator
    private class LibraryIterator implements BookIterator {

        private int index = 0;

        public boolean hasNext() {
            return index < books.size();
        }

        public String next() {
            return books.get(index++);
        }
    }
}

// Client
public class IteratorPatternDemo {

    public static void main(String[] args) {

        Library library = new Library();
        library.addBook("Clean Code");
        library.addBook("Effective Java");
        library.addBook("Design Patterns");

        BookIterator iterator = library.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```
---
## 🧩 Key Benefits
- Uniform traversal interface 
- Better encapsulation 
- Supports different collections 
- Cleaner client code

--
## 🔚 Conclusion

Iterator Pattern standardizes collection traversal without exposing internal structure.

Built directly into Java:

- Iterator
- Iterable
- Enhanced for-loop