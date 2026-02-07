package com.designpatterns.behavioral.mediator;

// Client
public class MediatorPatternDemo {

    public static void main(String[] args) {

        ChatMediator mediator = new ChatRoom();

        User ramesh = new ChatUser(mediator, "Ramesh");
        User arjun = new ChatUser(mediator, "Arjun");
        User priya = new ChatUser(mediator, "Priya");

        mediator.addUser(ramesh);
        mediator.addUser(arjun);
        mediator.addUser(priya);

        ramesh.send("Hello everyone!");
        arjun.send("Hi Ramesh!");
    }
}