package com.designpatterns.behavioral.memento;

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
