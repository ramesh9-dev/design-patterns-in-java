package com.designpatterns.structural.Adapter;

// Adapter: Bridges the gap between the Target (JsonService) and Adaptee (XmlService).
// It implements the Target interface and internally uses the Adaptee.
public class XmlToJsonAdapter implements JsonService {

    // Composition: Adapter HAS an Adaptee object.
    private XmlService xmlService;

    // Constructor injection of Adaptee.
    public XmlToJsonAdapter(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    // Converts XML to the JSON format expected by the client.
    @Override
    public String getJson() {
        // Get XML from the Adaptee
        String xml = xmlService.getXml();

        // Return mocked converted JSON.
        // In real scenarios, conversion logic is implemented here.
        return "{ \"message\": \"Converted from XML\" }";
    }
}
