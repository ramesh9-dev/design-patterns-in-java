package com.designpatterns.structural.FlyWeight;

import java.util.Random;

public class FlyweightDemo {
    public static void main(String[] args) {

        Random random = new Random();
        String[] colors = {"Red", "Blue", "Green", "Yellow"};

        for (int i = 0; i < 5; i++) {
            Shape circle = ShapeFactory.getCircle();  // shared object
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            String color = colors[random.nextInt(colors.length)];

            circle.draw(x, y, color);  // extrinsic state
        }
    }
}