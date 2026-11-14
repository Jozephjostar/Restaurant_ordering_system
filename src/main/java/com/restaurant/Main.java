package com.restaurant;

import com.restaurant.decorator.BaconDecorator;
import com.restaurant.decorator.CheeseDecorator;
import com.restaurant.decorator.SauceDecorator;
import com.restaurant.facade.RestaurantFacade;
import com.restaurant.factory.Food;
import com.restaurant.factory.FoodFactory;
import com.restaurant.model.Order;
import com.restaurant.model.OrderStatus;
import com.restaurant.strategy.NoDiscount;
import com.restaurant.strategy.PromoDiscount;
import com.restaurant.strategy.StudentDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RestaurantFacade restaurant = new RestaurantFacade();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== RESTAURANT ORDERING SYSTEM =====");
            System.out.println("1. View menu");
            System.out.println("2. Create order");
            System.out.println("3. View all orders");
            System.out.println("4. Update order status");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    restaurant.showAllOrders();
                    break;
                case 4:
                    updateOrderStatus();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Burger - 1800 KZT");
        System.out.println("2. Pizza - 2500 KZT");
        System.out.println("3. Salad - 1200 KZT");
        System.out.println("4. French Fries - 700 KZT");
        System.out.println("5. Cola - 500 KZT");
    }

    private static void createOrder() {
        List<Food> items = new ArrayList<>();
        boolean adding = true;

        while (adding) {
            showMenu();
            System.out.print("Choose food (1-5): ");

            int choice = readInt();
            Food food = null;

            switch (choice) {
                case 1:
                    food = FoodFactory.createFood("burger");
                    break;
                case 2:
                    food = FoodFactory.createFood("pizza");
                    break;
                case 3:
                    food = FoodFactory.createFood("salad");
                    break;
                case 4:
                    food = FoodFactory.createFood("fries");
                    break;
                case 5:
                    food = FoodFactory.createFood("cola");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            food = addExtras(food);
            items.add(food);

            System.out.println("Added: " + food.getName());

            System.out.print("Add another item? (1 - Yes, 0 - No): ");
            adding = readInt() == 1;
        }

        if (items.isEmpty()) {
            System.out.println("Order was not created.");
            return;
        }

        System.out.println("\nChoose discount:");
        System.out.println("1. No discount");
        System.out.println("2. Student discount (10%)");
        System.out.println("3. Promo discount (15%)");
        System.out.print("Your choice: ");

        int discountChoice = readInt();

        switch (discountChoice) {
            case 2:
                restaurant.setDiscountStrategy(new StudentDiscount());
                break;
            case 3:
                restaurant.setDiscountStrategy(new PromoDiscount());
                break;
            default:
                restaurant.setDiscountStrategy(new NoDiscount());
        }

        Order order = restaurant.placeOrder(items);

        System.out.println("\n===== ORDER CREATED =====");
        order.showDetails();

        double finalPrice = restaurant.calculateFinalPrice(order);

        System.out.println("Final price after discount: " + finalPrice + " KZT");
    }

    private static Food addExtras(Food food) {
        boolean adding = true;

        while (adding) {
            System.out.println("\nAdd extra:");
            System.out.println("1. Cheese (+300 KZT)");
            System.out.println("2. Bacon (+500 KZT)");
            System.out.println("3. Sauce (+150 KZT)");
            System.out.println("0. No more extras");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    food = new CheeseDecorator(food);
                    break;
                case 2:
                    food = new BaconDecorator(food);
                    break;
                case 3:
                    food = new SauceDecorator(food);
                    break;
                case 0:
                    adding = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        return food;
    }

    private static void updateOrderStatus() {
        restaurant.showAllOrders();

        System.out.print("\nEnter order ID: ");
        int id = readInt();

        System.out.println("1. Preparing");
        System.out.println("2. Ready");
        System.out.println("3. Delivered");
        System.out.print("Choose new status: ");

        int choice = readInt();
        OrderStatus status;

        switch (choice) {
            case 1:
                status = OrderStatus.PREPARING;
                break;
            case 2:
                status = OrderStatus.READY;
                break;
            case 3:
                status = OrderStatus.DELIVERED;
                break;
            default:
                System.out.println("Invalid status.");
                return;
        }

        restaurant.updateOrderStatus(id, status);
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a number: ");
            scanner.next();
        }

        return scanner.nextInt();
    }
}