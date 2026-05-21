# Practise Application

## Overview
Practise Application is a Spring Boot-based RESTful service designed to manage a basic e-commerce workflow, including product inventory management and order processing. The application ensures data integrity through transactional logic and validates stock availability before confirming orders.

## Features  
The following features have been implemented in the system:

### 1. Product Management
*   Full CRUD (Create, Read, Update, Delete) operations for products.
*   Validation for product details such as price (must be greater than 0) and stock quantity (cannot be negative).
*   Categorization and description of items.

### 2. Order Processing
*   Capability to place orders with multiple items.
*   Automatic calculation of the total order price based on product prices at the time of purchase.
*   Validation of product existence and stock availability during order creation.
*   Automated status assignment (e.g., CONFIRMED) and timestamping for new orders.

### 3. Inventory Management
*   Automatic deduction of stock quantities when an order is successfully placed.
*   Transactional consistency ensuring that stock is only deducted if the entire order process succeeds.

### 4. Configuration and Security
*   Environment variable support via `.env` files for sensitive data like database credentials.
*   Database schema management using Hibernate's ddl-auto feature.
*   API documentation integration using SpringDoc OpenAPI (Swagger UI).

## Folder Structure

The project follows a standard Maven and Spring Boot layered architecture:

```text
src/main/java/com/example/practise/
├── controllers/          # REST Controllers handling HTTP requests and responses.
│   ├── OrderController.java
│   └── ProductController.java
├── dto/                  # Data Transfer Objects for API request payloads.
│   ├── OrderItemRequest.java
│   └── OrderRequest.java
├── entities/             # JPA Entities representing database tables.
│   ├── Order.java
│   ├── OrderItem.java
│   └── Product.java
├── repositries/          # Spring Data JPA Repositories for database abstraction.
│   ├── OrderItemRepository.java
│   ├── OrderRepository.java
│   └── ProductRepository.java
├── services/             # Business logic layer containing core application rules.
│   ├── OrderService.java
│   └── ProductService.java
└── PractiseApplication.java # Application entry point and configuration loader.
```

### Component Explanations:
*   **Controllers**: Define the API endpoints. They receive user input, call the appropriate service methods, and return responses.
*   **DTOs**: Decouple the internal database schema from the external API. They ensure that only required fields are exposed or accepted.
*   **Entities**: Map Java objects to PostgreSQL database tables using Jakarta Persistence (JPA).
*   **Repositories**: Provide an interface for performing CRUD operations without writing manual SQL queries.
*   **Services**: The core of the application where business logic resides, such as checking stock levels and calculating totals.
*   **Resources**: Contains `application.yml` for framework settings and static/template folders for potential front-end assets.

## Implementation Details

### Transaction Management
The `OrderService` uses the `@Transactional` annotation. This ensures that when an order is placed, the creation of the order record, the creation of order items, and the update of product stock levels all happen as a single atomic unit. If any part fails (e.g., insufficient stock), the entire operation rolls back to maintain data consistency.

### Database Integration
The application is configured to connect to a PostgreSQL database. It uses environment variables (`DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`) to manage connections securely, which are loaded at runtime by the `Dotenv` library in the main class.

### Validation
Bean Validation (JSR 380) is used across DTOs and Entities to ensure that incoming data meets specific criteria, such as valid email formats for customers and minimum quantity requirements for orders.
