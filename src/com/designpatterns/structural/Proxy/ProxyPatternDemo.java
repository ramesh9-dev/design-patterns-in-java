package com.designpatterns.structural.Proxy;

// 4️⃣ Client Code
public class ProxyPatternDemo {
    public static void main(String[] args) {

        Image image = new ProxyImage("pic.jpeg");

        // Image will be loaded only on first display() call
        image.display();

        System.out.println("---------");

        // This time image will NOT be loaded again
        image.display();
    }
}
