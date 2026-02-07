package com.designpatterns.behavioral.memento;

import java.util.Stack;

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