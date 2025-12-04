package com.designpatterns.structural.FlyWeight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getCircle() {
        String key = "circle";

        if (!shapeMap.containsKey(key)) {
            shapeMap.put(key, new Circle());
        }

        return shapeMap.get(key);
    }
}