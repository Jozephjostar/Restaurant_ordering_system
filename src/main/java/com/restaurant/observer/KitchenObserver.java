package com.restaurant.observer;

import com.restaurant.model.OrderStatus;

public class KitchenObserver implements OrderObserver {
    public void update(OrderStatus status) {
        System.out.println("Kitchen notification: Order status changed to " + status);
    }
}