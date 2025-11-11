package com.designpatterns.creational.prototype.deepcopy;

import com.designpatterns.creational.prototype.Prototype;

// Employee class implementing Deep Copy
class Employee implements Prototype {
    private int id;
    private String name;
    private Address address;  // Reference type

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Deep copy
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.address = (Address) address.clone();  // Deep copy for nested object
        return cloned;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}
