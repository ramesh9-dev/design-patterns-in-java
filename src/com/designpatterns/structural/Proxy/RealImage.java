package com.designpatterns.structural.Proxy;

// 2️⃣ Real Subject
// This is the real object that is expensive to create
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
        // heavy loading operation
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}