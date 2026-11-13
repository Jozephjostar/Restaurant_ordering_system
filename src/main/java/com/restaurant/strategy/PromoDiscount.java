package com.restaurant.strategy;

public class PromoDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        return total * 0.85;
    }
}