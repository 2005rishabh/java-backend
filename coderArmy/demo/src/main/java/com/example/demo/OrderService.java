package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.payment.PaymentService;

@Component
public class OrderService {
    // @Autowired
    private final PaymentService p;

    public OrderService(PaymentService paymentService) {
        this.p = paymentService;
    }

    public void placeOrder() {
        p.pay();
        System.out.println("Order placed successfully");
    }
}
