package com.designpatterns.creational.prototype.deepcopy;

// Address class (Referenced object)
class Address implements Cloneable {
    String city;
    String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    // Deep copy implementation for Address
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Address(this.city, this.country);
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

