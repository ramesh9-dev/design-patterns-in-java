package com.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

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