package com.designpatterns.structural.Decorator;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;  // Composition: HAS-A relationship

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}