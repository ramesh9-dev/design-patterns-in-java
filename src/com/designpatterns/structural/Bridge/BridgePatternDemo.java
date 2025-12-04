package com.designpatterns.structural.Bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {

        Shape redCircle = new Circle(new RedColor());
        redCircle.draw();

        Shape blueSquare = new Square(new BlueColor());
        blueSquare.draw();
    }
}