package com.designpatterns.creational.prototype.deepcopy;

// Client class
public class DeepCopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Hyderabad", "India");
        Employee emp1 = new Employee(101, "Ramesh", address);

        // Deep copy
        Employee emp2 = (Employee) emp1.clone();

        System.out.println("Before modification:");
        System.out.println("emp1 = " + emp1);
        System.out.println("emp2 = " + emp2);

        // Modify emp2's address
        emp2.getAddress().city = "Bangalore";

        System.out.println("\nAfter modifying emp2's address:");
        System.out.println("emp1 = " + emp1);
        System.out.println("emp2 = " + emp2);
    }
}
