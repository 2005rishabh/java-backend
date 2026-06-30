package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService p;

    public OrderService(PaymentService paymentService) {
        this.p = paymentService;
    }

    public void placeOrder() {
        p.pay();
        System.out.println("Order placed successfully");
    }
}
