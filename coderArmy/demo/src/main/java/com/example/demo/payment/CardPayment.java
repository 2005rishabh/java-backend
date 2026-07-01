package com.example.demo.payment;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Card payment");
    }
}