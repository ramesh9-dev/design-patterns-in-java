package com.designpatterns.behavioral.visitor;

// Client
public class VisitorPatternDemo {

    public static void main(String[] args) {

        Item[] items = {
                new Book(500),
                new Electronics(2000)
        };

        ShoppingCartVisitor visitor = new PriceCalculatorVisitor();

        double total = 0;
        for (Item item : items) {
            total += item.accept(visitor);
        }

        System.out.println("Total cost = " + total);
    }
}