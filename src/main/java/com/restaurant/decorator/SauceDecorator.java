package com.restaurant.decorator;

import com.restaurant.factory.Food;

public class SauceDecorator extends FoodDecorator {
    public SauceDecorator(Food food) {
        super(food);
    }

    public String getName() {
        return food.getName() + " + Sauce";
    }

    public double getPrice() {
        return food.getPrice() + 150;
    }
}