package com.designpatterns.structural.Adapter;

// Client: Works with objects through the Target interface.
// It does not know anything about the Adaptee.
public class AdapterPatternDemo {

    public static void main(String[] args) {

        // Creating Adaptee object
        XmlService xmlService = new XmlService();

        // Wrapping Adaptee inside the Adapter
        JsonService jsonService = new XmlToJsonAdapter(xmlService);

        // Client works with JSON output only
        System.out.println(jsonService.getJson());
    }
}
