<!-- TOC -->
* [💾 Memento Pattern](#-memento-pattern)
    * [📌 Overview](#-overview)
    * [🎯 Purpose](#-purpose)
    * [🧠 When to Use](#-when-to-use)
    * [🏗 Structure](#-structure)
    * [📘 Example: Text Editor Undo System](#-example-text-editor-undo-system)
    * [✅ Complete Java Code (Single Block)](#-complete-java-code-single-block)
    * [🧩 Key Benefits](#-key-benefits)
    * [🔚 Conclusion](#-conclusion)
<!-- TOC -->

# 💾 Memento Pattern

## 📌 Overview

The **Memento Pattern** captures and stores an object’s internal state without violating encapsulation,
so it can be restored later.

---

## 🎯 Purpose

- Implement undo/rollback
- Save object snapshots
- Restore previous states safely
- Preserve encapsulation

---

## 🧠 When to Use

- Need undo/redo functionality
- State recovery
- Versioning systems
- Transaction rollback

---

## 🏗 Structure

```
Originator → creates/restores state
Memento → stores state
Caretaker → manages mementos
```


---

## 📘 Example: Text Editor Undo System

Save text content snapshots and restore previous versions.

---

## ✅ Complete Java Code (Single Block)

```java
import java.util.*;

// Memento Class
class EditorMemento {
    private final String content;

    EditorMemento(String content) {
        this.content = content;
    }

    String getContent() {
        return content;
    }
}

// Originator
class TextEditor {

    private String content = "";

    void write(String text) {
        content += text;
    }

    String getContent() {
        return content;
    }

    EditorMemento save() {
        return new EditorMemento(content);
    }

    void restore(EditorMemento memento) {
        content = memento.getContent();
    }
}

// Caretaker
class History {

    private Stack<EditorMemento> history = new Stack<>();

    void save(EditorMemento memento) {
        history.push(memento);
    }

    EditorMemento undo() {
        return history.pop();
    }
}

// Client
public class MementoPatternDemo {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello ");
        history.save(editor.save());

        editor.write("World ");
        history.save(editor.save());

        editor.write("!!!");

        System.out.println("Current: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("After undo: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("After second undo: " + editor.getContent());
    }
}
```
---
## 🧩 Key Benefits
- Safe state restoration 
- Encapsulation preserved 
- Clean undo logic 
- Simple rollback support

---
## 🔚 Conclusion
Memento Pattern provides a clean way to capture and restore object states without exposing internals.

Used in:

- Undo/Redo systems 
- Transaction rollback 
- Version history 
- Game save checkpoints