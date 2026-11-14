package com.restaurant.builder;

import com.restaurant.factory.Food;
import com.restaurant.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private final List<Food> items = new ArrayList<>();

    public OrderBuilder addItem(Food food) {
        items.add(food);
        return this;
    }

    public OrderBuilder addItems(List<Food> foods) {
        items.addAll(foods);
        return this;
    }

    public Order build() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Order cannot be empty");
        }

        return new Order(items);
    }
}