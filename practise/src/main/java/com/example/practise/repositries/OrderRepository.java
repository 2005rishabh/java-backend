package com.example.practise.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practise.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
