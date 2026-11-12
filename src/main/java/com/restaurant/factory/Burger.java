package com.restaurant.factory;

public class Burger implements Food {
    public String getName() {
        return "Burger";
    }

    public double getPrice() {
        return 1800;
    }
}