package com.example.demo.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier

public class CardPayment implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Card payment");
    }
}