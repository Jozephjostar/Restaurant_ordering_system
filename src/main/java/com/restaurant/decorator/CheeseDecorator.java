package com.restaurant.decorator;

import com.restaurant.factory.Food;

public class CheeseDecorator extends FoodDecorator {
    public CheeseDecorator(Food food) {
        super(food);
    }

    public String getName() {
        return food.getName() + " + Cheese";
    }

    public double getPrice() {
        return food.getPrice() + 300;
    }
}