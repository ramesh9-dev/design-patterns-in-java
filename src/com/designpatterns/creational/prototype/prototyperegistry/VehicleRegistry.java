package com.designpatterns.creational.prototype.prototyperegistry;

import java.util.HashMap;
import java.util.Map;

class VehicleRegistry {
    private static Map<String, Vehicle> registry = new HashMap<>();

    static {
        // Preload some prototype objects
        registry.put("basicCar", new Car("Suzuki Swift", 800000, 4));
        registry.put("sportsCar", new Car("Porsche 911", 12000000, 2));
        registry.put("mountainBike", new Bike("Hero MTB", 55000, true));
    }

    public static Vehicle getVehicle(String type) throws CloneNotSupportedException {
        Vehicle prototype = registry.get(type);
        if (prototype != null) {
            return (Vehicle) prototype.clone(); // Return clone
        }
        throw new IllegalArgumentException("Vehicle type not found in registry!");
    }
}
