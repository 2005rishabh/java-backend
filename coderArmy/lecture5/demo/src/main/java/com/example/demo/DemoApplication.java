package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // 1. Capture the context Spring Boot creates
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        // 2. Retrieve your bean from the booted context
        OrderService order = context.getBean(OrderService.class);

        // 3. Run your method
        order.placeOrder();
    }
}