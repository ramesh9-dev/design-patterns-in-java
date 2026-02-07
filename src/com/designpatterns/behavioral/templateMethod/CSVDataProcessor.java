package com.designpatterns.behavioral.templateMethod;

// Concrete Class 1
class CSVDataProcessor extends DataProcessor {

    protected void readData() {
        System.out.println("Reading data from CSV file");
    }

    protected void processData() {
        System.out.println("Processing CSV data");
    }
}