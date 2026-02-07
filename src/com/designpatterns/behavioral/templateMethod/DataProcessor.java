package com.designpatterns.behavioral.templateMethod;

// Abstract Template Class
abstract class DataProcessor {

    // Template method (final to prevent override)
    public final void process() {
        readData();
        processData();
        saveData();
    }

    protected abstract void readData();

    protected abstract void processData();

    protected void saveData() {
        System.out.println("Saving processed data to database");
    }
}
