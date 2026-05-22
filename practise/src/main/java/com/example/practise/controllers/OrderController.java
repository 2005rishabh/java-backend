package com.example.practise.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practise.dto.OrderRequest;
import com.example.practise.entities.Order;
import com.example.practise.services.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);

    }

    // Get all orders
    @GetMapping()
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    // Get order by id

    @GetMapping("/{id}")
    public Order getOrderByID(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
