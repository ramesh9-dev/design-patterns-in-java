package com.designpatterns.behavioral.memento;

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