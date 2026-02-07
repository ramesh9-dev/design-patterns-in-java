package com.designpatterns.behavioral.iterator;


// Aggregate Interface
interface BookCollection {
    BookIterator createIterator();
}