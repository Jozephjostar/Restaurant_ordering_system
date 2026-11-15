#  Restaurant Ordering System

A Java-based restaurant ordering system developed as a team project to demonstrate the practical application of **Software Design Patterns**.

The system allows customers to select food items, customize their meals with additional ingredients, apply discounts, create orders, and track order statuses.

##  Project Overview

The Restaurant Ordering System demonstrates how different design patterns can work together in one application.

The project uses six design patterns:

1. **Factory Pattern** - creates food objects.
2. **Decorator Pattern** - adds extra ingredients to food items.
3. **Strategy Pattern** - applies different discount strategies.
4. **Observer Pattern** - notifies observers when an order status changes.
5. **Builder Pattern** - constructs orders step by step.
6. **Facade Pattern** - provides a unified interface for restaurant operations.

##  Technologies

- Java 17
- Object-Oriented Programming (OOP)
- Software Design Patterns
- Maven

##  Main Features

- Create food items such as Burger, Pizza, Salad, Fries, and Cola.
- Customize food with additional ingredients.
- Calculate food prices dynamically.
- Apply discount strategies.
- Build restaurant orders.
- Track order statuses.
- Notify customers and kitchen observers about status changes.

##  Design Patterns

### 1. Factory Pattern

The Factory Pattern is responsible for creating food objects.

The `FoodFactory` class provides the `createFood()` method, which creates the requested food item based on its type.

Supported food items:

| Food | Price |
|---|---:|
| Burger | 1800 KZT |
| Pizza | 2500 KZT |
| Salad | 1200 KZT |
| French Fries | 700 KZT |
| Cola | 500 KZT |

Example:

```java
Food burger = FoodFactory.createFood("burger");
```

The factory returns a new `Burger` object.

### 2. Decorator Pattern

The Decorator Pattern allows additional ingredients to be added to existing food objects without modifying their original classes.

The project includes three decorators:

| Decorator | Additional Price |
|---|---:|
| CheeseDecorator | +300 KZT |
| BaconDecorator | +500 KZT |
| SauceDecorator | +150 KZT |

Example:

```java
Food food = FoodFactory.createFood("burger");

food = new CheeseDecorator(food);
food = new BaconDecorator(food);
food = new SauceDecorator(food);

System.out.println(food.getName());
System.out.println(food.getPrice());
```

Output:

```text
Burger + Cheese + Bacon + Sauce
2750.0
```

The final price is calculated dynamically by combining the original food price with the prices of the added ingredients.

### 3. Strategy Pattern

The Strategy Pattern allows the application to use different discount calculation algorithms.

Examples include:

- No Discount
- Student Discount
- Promotional Discount

Each strategy implements the common discount interface.

### 4. Observer Pattern

The Observer Pattern is used to notify interested objects when an order status changes.

For example, customers and kitchen staff can receive notifications when an order is updated.

### 5. Builder Pattern

The Builder Pattern simplifies the creation of orders by allowing food items to be added step by step.

Example:

```java
Order order = new OrderBuilder()
    .addItem(burger)
    .addItem(cola)
    .build();
```

### 6. Facade Pattern

The Facade Pattern provides a simplified interface for interacting with different parts of the system.

The `RestaurantFacade` coordinates operations such as order creation, discount calculation, and status updates.

##  Project Structure

```text
src/
└── main/
    └── java/
        └── com/
            └── restaurant/
                ├── factory/
                │   ├── Food.java
                │   ├── FoodFactory.java
                │   ├── Burger.java
                │   ├── Pizza.java
                │   ├── Salad.java
                │   ├── Fries.java
                │   └── Cola.java
                │
                ├── decorator/
                │   ├── FoodDecorator.java
                │   ├── CheeseDecorator.java
                │   ├── BaconDecorator.java
                │   └── SauceDecorator.java
                │
                ├── strategy/
                ├── observer/
                ├── builder/
                ├── facade/
                └── model/
```

##  Team Members and Responsibilities

| Team Member | Responsibilities |
|---|---|
| Maksut Alibi | Factory Pattern, Decorator Pattern |
| Muratbek Akyl | Strategy Pattern, Observer Pattern |
| Nursultan Maratov | Builder Pattern, Facade Pattern |

##  Example Scenario

A customer creates an order with a burger and adds cheese, bacon, and sauce.

Price calculation:

```text
Burger:       1800 KZT
Cheese:        300 KZT
Bacon:         500 KZT
Sauce:         150 KZT
-----------------------
Total:        2750 KZT
```

The system can then apply a discount strategy and create an order.

##  Future Improvements

Possible improvements include:

- Database integration using PostgreSQL or MySQL.
- A graphical user interface using JavaFX or a web framework.
- Automated unit testing with JUnit.
- Email and push notifications.
- Persistent storage of restaurant orders.

##  Project Goal

The main goal of this project is to demonstrate how software design patterns improve code organization, flexibility, maintainability, and reusability in a restaurant ordering application.
