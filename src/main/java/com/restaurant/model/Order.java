package com.restaurant.model;

import com.restaurant.factory.Food;
import com.restaurant.observer.OrderObserver;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 1;

    private final int id;
    private final List<Food> items;
    private OrderStatus status;
    private final List<OrderObserver> observers;

    public Order(List<Food> items) {
        this.id = nextId++;
        this.items = new ArrayList<>(items);
        this.status = OrderStatus.CREATED;
        this.observers = new ArrayList<>();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;

        for (OrderObserver observer : observers) {
            observer.update(status);
        }
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<Food> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;

        for (Food food : items) {
            total += food.getPrice();
        }

        return total;
    }

    public void showDetails() {
        System.out.println("\nOrder #" + id);

        for (Food food : items) {
            System.out.println(food.getName() + " - " + food.getPrice() + " KZT");
        }

        System.out.println("Status: " + status);
        System.out.println("Total: " + getTotal() + " KZT");
    }
}