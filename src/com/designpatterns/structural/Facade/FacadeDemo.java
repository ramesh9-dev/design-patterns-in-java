package com.designpatterns.structural.Facade;

public class FacadeDemo {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();  // Client interacts with simplified interface
    }
}