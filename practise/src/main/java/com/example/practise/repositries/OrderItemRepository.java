package com.example.practise.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practise.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
