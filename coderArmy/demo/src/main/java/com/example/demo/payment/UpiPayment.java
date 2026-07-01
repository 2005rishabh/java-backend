package com.example.demo.payment;

import org.springframework.stereotype.Component;

@Component
public class UpiPayment implements PaymentService {
    @Override
    public void pay() {
        System.out.println("UPI payment");
    }
}
