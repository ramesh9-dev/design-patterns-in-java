package com.designpatterns.creational.abstractfactory;

// Client
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory factory;
        Button button;
        Checkbox checkbox;
        //windows
        factory = getGuiFactory("windows");
        button = factory.createButton();
        checkbox = factory.createCheckbox();

        button.render();
        checkbox.check();

        //mac
        factory = getGuiFactory("mac");
        button = factory.createButton();
        checkbox = factory.createCheckbox();

        button.render();
        checkbox.check();
    }

    private static GUIFactory getGuiFactory(String osName) {
        GUIFactory factory;
        if (osName.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else if (osName.equalsIgnoreCase("Mac")) {
            factory = new MacFactory();
        } else {
            throw new UnsupportedOperationException("Unsupported OS");
        }
        return factory;
    }
}
