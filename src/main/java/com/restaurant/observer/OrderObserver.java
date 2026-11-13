package com.restaurant.observer;

import com.restaurant.model.OrderStatus;

public interface OrderObserver {
    void update(OrderStatus status);
}