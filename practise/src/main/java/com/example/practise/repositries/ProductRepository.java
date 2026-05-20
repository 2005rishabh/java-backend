package com.example.practise.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practise.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    

}
