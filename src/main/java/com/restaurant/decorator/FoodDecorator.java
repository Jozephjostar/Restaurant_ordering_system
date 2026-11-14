package com.restaurant.decorator;

import com.restaurant.factory.Food;

public abstract class FoodDecorator implements Food {
    protected Food food;

    public FoodDecorator(Food food) {
        this.food = food;
    }
}