package com.designpatterns.behavioral.templateMethod;

// Client
public class TemplateMethodDemo {

    public static void main(String[] args) {

        DataProcessor csv = new CSVDataProcessor();
        csv.process();

        System.out.println();

        DataProcessor xml = new XMLDataProcessor();
        xml.process();
    }
}