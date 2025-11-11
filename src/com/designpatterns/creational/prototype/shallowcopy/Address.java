package com.designpatterns.creational.prototype.shallowcopy;

// Address class (Referenced object)
class Address {
    String city;
    String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}
