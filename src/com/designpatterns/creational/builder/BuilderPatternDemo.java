package com.designpatterns.creational.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .setName("John")
                .setAge(25)
                .setEmail("john@mail.com")
                .setAddress("New York")
                .setAdmin(true)
                .build();

        System.out.println(user);
    }
}
