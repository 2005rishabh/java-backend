# Practise Application

## Overview

Practise Application is a Spring Boot-based RESTful service designed to manage a basic e-commerce workflow, including product inventory management and order processing. The application ensures data integrity through transactional logic and validates stock availability before confirming orders.

## Features

The following features have been implemented in the system:

### 1. Product Management

- Full CRUD (Create, Read, Update, Delete) operations for products.
- Validation for product details such as price (must be greater than 0) and stock quantity (cannot be negative).
- Categorization and description of items.

### 2. Order Processing

- Capability to place orders with multiple items.
- Retrieve all orders or a specific order by its unique identifier.
- Automatic calculation of the total order price based on product prices at the time of purchase.
- Validation of product existence and stock availability during order creation.
- Automated status assignment (e.g., CONFIRMED) and timestamping for new orders.

### 3. Inventory Management

- Automatic deduction of stock quantities when an order is successfully placed.
- Transactional consistency ensuring that stock is only deducted if the entire order process succeeds.

### 4. Security and Authentication

- JWT-based stateless authentication for protected APIs.
- Public endpoints under `/api/auth/**` for signup and login.
- Registered users are saved with BCrypt-hashed passwords.
- `JwtAuthFilter` validates the `Authorization: Bearer <token>` header and sets the Spring Security context.
- `WebSecurityConfig` permits authentication and Swagger routes, and secures all other requests.
- `GlobalExceptionHandler` returns structured `ApiError` responses for authentication failures, JWT issues, access denied errors, and general exceptions.

### 5. Error Handling

- Input validation using Jakarta Bean Validation (e.g., `@Valid`, `@NotNull`, `@Min`).
- Business logic validation for stock availability with informative error messages.
- Resource lookup validation: Throws descriptive exceptions when Products, Orders, or Users are missing.
- Transactional rollback: Ensures data consistency by rolling back changes if an exception occurs during order placement.

### 6. Configuration and Startup

- Environment variables are loaded from a `.env` file via the `Dotenv` library in `PractiseApplication.java`.
- The application first checks the current working directory for `.env`. If it is missing, it falls back to the `practise/` subfolder.
- This path fallback resolves startup issues when running the app from the parent directory.
- Required environment variables:
  - `DATABASE_URL`
  - `DATABASE_USERNAME`
  - `DATABASE_PASSWORD`
  - `JWT_SECRET`
- `application.yml` uses Spring property placeholders so sensitive values are not hard-coded.

## Folder Structure

The project follows a standard Maven and Spring Boot layered architecture:

```text
src/main/java/com/example/practise/
├── controllers/          # REST Controllers handling HTTP requests and responses.
│   ├── AuthController.java
│   ├── OrderController.java
│   └── ProductController.java
├── dto/                  # Data Transfer Objects for API request payloads.
│   ├── LoginRequest.java
│   ├── LoginResponse.java
│   ├── OrderItemRequest.java
│   ├── OrderRequest.java
│   └── SignupResponse.java
├── entities/             # JPA Entities representing database tables.
│   ├── Order.java
│   ├── OrderItem.java
│   ├── Product.java
│   └── User.java
├── error/                # Exception handling support classes.
│   ├── ApiError.java
│   └── GlobalExceptionHandler.java
├── repositries/          # Spring Data JPA Repositories for database abstraction.
│   ├── OrderItemRepository.java
│   ├── OrderRepository.java
│   ├── ProductRepository.java
│   └── UserRepository.java
├── security/             # Security configuration and JWT support.
│   ├── AuthUtil.java
│   ├── JwtAuthFilter.java
│   ├── WebSecurityConfig.java
│   └── CustomUserDetailService.java
├── services/             # Business logic layer containing core application rules.
│   ├── AuthService.java
│   ├── OrderService.java
│   └── ProductService.java
└── PractiseApplication.java # Application entry point and configuration loader.
```

### Component Explanations:

- **Controllers**: Define the API endpoints. They receive user input, call the appropriate service methods, and return responses.
- **DTOs**: Decouple the internal database schema from the external API. They ensure that only required fields are exposed or accepted.
- **Entities**: Map Java objects to PostgreSQL database tables using Jakarta Persistence (JPA).
- **Repositories**: Provide an interface for performing CRUD operations without writing manual SQL queries.
- **Security**: Manages JWT authentication, filter-based authorization, and user credential verification.
- **Error**: Centralizes exception handling and transforms exceptions into consistent API responses.
- **Services**: The core of the application where business logic resides, such as checking stock levels and calculating totals.
- **Resources**: Contains `application.yml` for framework settings and static/template folders for potential front-end assets.

## Implementation Details

### Application Startup

The application entry point is `PractiseApplication.java`. It:

- detects the active working directory,
- looks for a `.env` file in that directory,
- falls back to `practise/.env` if needed,
- loads sensitive environment settings into system properties,
- then starts Spring Boot.

This ensures the app can start correctly even if the command is run from the repo root rather than the module folder.

### Transaction Management

The `OrderService` uses the `@Transactional` annotation. This ensures that when an order is placed, the creation of the order record, the creation of order items, and the update of product stock levels all happen as a single atomic unit. If any part fails (e.g., insufficient stock), the entire operation rolls back to maintain data consistency.

### Database Integration

The application is configured to connect to a PostgreSQL database. It uses environment variables (`DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`) to manage connections securely, which are loaded at runtime by the `Dotenv` library in the main class.

### Validation

Bean Validation (JSR 380) is used across DTOs and Entities to ensure that incoming data meets specific criteria, such as valid email formats for customers and minimum quantity requirements for orders.

### Running the App

From the `practise/` folder:

```bash
cd "/home/rishabh-developer/Documents/java backend/practise"
./mvnw spring-boot:run
```

If you run from the repository root, the startup logic will still locate `.env` correctly by checking the `practise` subfolder.
