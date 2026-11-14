package com.restaurant.strategy;

public class StudentDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        return total * 0.90;
    }
}