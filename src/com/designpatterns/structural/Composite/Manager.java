package com.designpatterns.structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private String name;
    private String position;
    private List<Employee> employees = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employees.remove(emp);
    }

    @Override
    public void showDetails() {
        System.out.println(name + " - " + position);
        System.out.println("Team:");
        for (Employee emp : employees) {
            emp.showDetails();
        }
    }
}