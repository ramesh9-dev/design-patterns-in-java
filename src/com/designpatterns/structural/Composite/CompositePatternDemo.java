package com.designpatterns.structural.Composite;

public class CompositePatternDemo {
    public static void main(String[] args) {

        Employee dev1 = new Developer("Ramesh", "Frontend Developer");
        Employee dev2 = new Developer("Suresh", "Backend Developer");
        Employee designer = new Designer("Mahesh", "UX Designer");

        Manager manager = new Manager("Lokesh", "Project Manager");

        manager.addEmployee(dev1);
        manager.addEmployee(dev2);
        manager.addEmployee(designer);

        manager.showDetails();
    }
}