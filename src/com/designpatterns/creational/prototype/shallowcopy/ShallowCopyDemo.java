package com.designpatterns.creational.prototype.shallowcopy;

// Client class
public class ShallowCopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Hyderabad", "India");
        Employee emp1 = new Employee(101, "JhonnyDepp", address);

        // Shallow copy
        Employee emp2 = (Employee) emp1.clone();

        System.out.println("Before modification:");
        System.out.println("emp1 = " + emp1);
        System.out.println("emp2 = " + emp2);

        // Modify the address of emp2
        emp2.getAddress().city = "Bangalore";
        System.out.println("\nAfter modifying emp2's address:");
        System.out.println("emp1 = " + emp1);
        System.out.println("emp2 = " + emp2);
    }
}
