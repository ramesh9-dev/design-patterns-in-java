package com.designpatterns.creational.prototype;

// Prototype Interface
public interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
}
