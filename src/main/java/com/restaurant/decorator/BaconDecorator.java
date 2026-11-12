package com.restaurant.decorator;

import com.restaurant.factory.Food;

public class BaconDecorator extends FoodDecorator {
    public BaconDecorator(Food food) {
        super(food);
    }

    public String getName() {
        return food.getName() + " + Bacon";
    }

    public double getPrice() {
        return food.getPrice() + 500;
    }
}