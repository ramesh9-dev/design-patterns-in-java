package com.designpatterns.structural.Proxy;

// 3️⃣ Proxy Class (Lazy Loading)
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // Create object only when needed (Lazy Loading)
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}