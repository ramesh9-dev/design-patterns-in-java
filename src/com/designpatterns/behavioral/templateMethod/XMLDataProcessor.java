package com.designpatterns.behavioral.templateMethod;

// Concrete Class 2
class XMLDataProcessor extends DataProcessor {

    protected void readData() {
        System.out.println("Reading data from XML file");
    }

    protected void processData() {
        System.out.println("Processing XML data");
    }
}