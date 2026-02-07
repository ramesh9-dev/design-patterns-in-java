package com.designpatterns.behavioral.visitor;

// Visitor Interface
interface ShoppingCartVisitor {
    double visit(Book book);

    double visit(Electronics electronics);
}

// Concrete Visitor
class PriceCalculatorVisitor implements ShoppingCartVisitor {

    public double visit(Book book) {
        return book.getPrice() * 0.9; // 10% discount
    }

    public double visit(Electronics electronics) {
        return electronics.getPrice() * 1.18; // tax added
    }
}
