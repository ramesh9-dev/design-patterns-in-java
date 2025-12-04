package com.designpatterns.structural.Facade;

public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Loading data to memory at position " + position);
    }
}