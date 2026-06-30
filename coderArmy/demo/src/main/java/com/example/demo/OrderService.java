package com.example.demo;

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
