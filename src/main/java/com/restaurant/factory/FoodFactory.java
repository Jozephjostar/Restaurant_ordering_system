package com.restaurant.factory;

public class FoodFactory {
    public static Food createFood(String type) {
        switch (type.toLowerCase()) {
            case "burger":
                return new Burger();
            case "pizza":
                return new Pizza();
            case "salad":
                return new Salad();
            case "fries":
                return new Fries();
            case "cola":
                return new Cola();
            default:
                throw new IllegalArgumentException("Unknown food: " + type);
        }
    }
}