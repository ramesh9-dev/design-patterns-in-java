package com.designpatterns.creational.prototype.shallowcopy;

import com.designpatterns.creational.prototype.Prototype;

// Employee class implementing shallow copy
class Employee implements Prototype {
    private int id;
    private String name;
    private Address address;  // Reference type

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Shallow copy - just call super.clone()
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
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
