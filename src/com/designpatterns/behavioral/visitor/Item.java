package com.designpatterns.behavioral.visitor;

// Element Interface
interface Item {
    double accept(ShoppingCartVisitor visitor);
}

// Concrete Element 1
class Book implements Item {

    private double price;

    Book(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

// Concrete Element 2
class Electronics implements Item {

    private double price;

    Electronics(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}