package com.designpatterns.behavioral.iterator;

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