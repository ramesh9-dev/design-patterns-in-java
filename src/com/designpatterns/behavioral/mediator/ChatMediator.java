package com.designpatterns.behavioral.mediator;

import java.util.*;

// Mediator Interface
interface ChatMediator {
    void sendMessage(String message, User user);

    void addUser(User user);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}