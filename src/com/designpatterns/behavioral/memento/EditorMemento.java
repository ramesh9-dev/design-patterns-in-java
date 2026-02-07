package com.designpatterns.behavioral.memento;

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