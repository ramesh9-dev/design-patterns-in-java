package com.designpatterns.structural.Adapter;

// Adaptee: This is an existing class whose interface is incompatible
// with what the client expects.
public class XmlService {

    // Method returning XML data instead of JSON.
    public String getXml() {
        return "<message>Hello from XML</message>";
    }
}
