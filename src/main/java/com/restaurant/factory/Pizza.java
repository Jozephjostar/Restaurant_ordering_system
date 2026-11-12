package com.restaurant.factory;

public class Pizza implements Food {
    public String getName() {
        return "Pizza";
    }

    public double getPrice() {
        return 2500;
    }
}