package com.designpatterns.behavioral.mediator;

// Colleague Abstract Class
abstract class User {

    protected ChatMediator mediator;
    protected String name;

    User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String message);

    abstract void receive(String message);
}

// Concrete Colleague
class ChatUser extends User {

    ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    void receive(String message) {
        System.out.println(name + " receives: " + message);
    }
}
