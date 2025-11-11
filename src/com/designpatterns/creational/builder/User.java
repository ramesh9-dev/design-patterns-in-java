package com.designpatterns.creational.builder;

class User {
    private final String name;
    private final int age;
    private final String email;
    private final String address;
    private final boolean isAdmin;

    // private constructor to prevent direct creation
    private User(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;
        this.isAdmin = builder.isAdmin;
    }

    // static nested Builder class
    public static class UserBuilder {
        private String name;
        private int age;
        private String email;
        private String address;
        private boolean isAdmin;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", email=" + email +
                ", address=" + address + ", isAdmin=" + isAdmin + "]";
    }
}

