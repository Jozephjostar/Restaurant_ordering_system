package com.restaurant.facade;

import com.restaurant.builder.OrderBuilder;
import com.restaurant.factory.Food;
import com.restaurant.model.Order;
import com.restaurant.model.OrderStatus;
import com.restaurant.observer.CustomerObserver;
import com.restaurant.observer.KitchenObserver;
import com.restaurant.strategy.DiscountStrategy;
import com.restaurant.strategy.NoDiscount;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFacade {
    private final List<Order> orders = new ArrayList<>();
    private DiscountStrategy discountStrategy = new NoDiscount();

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public Order placeOrder(List<Food> items) {
        OrderBuilder builder = new OrderBuilder();
        builder.addItems(items);

        Order order = builder.build();

        order.addObserver(new CustomerObserver());
        order.addObserver(new KitchenObserver());

        orders.add(order);

        return order;
    }

    public double calculateFinalPrice(Order order) {
        return discountStrategy.applyDiscount(order.getTotal());
    }

    public void updateOrderStatus(int orderId, OrderStatus status) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                order.setStatus(status);
                return;
            }
        }

        System.out.println("Order not found.");
    }

    public void showAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }

        for (Order order : orders) {
            order.showDetails();
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}