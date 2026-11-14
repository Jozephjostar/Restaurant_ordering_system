package com.restaurant.observer;

import com.restaurant.model.OrderStatus;

public class CustomerObserver implements OrderObserver {
    public void update(OrderStatus status) {
        System.out.println("Customer notification: Your order is " + status);
    }
}