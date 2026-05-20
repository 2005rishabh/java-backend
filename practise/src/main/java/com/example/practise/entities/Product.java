package com.example.practise.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is req")
    @Column(nullable = false) 
    private String name;
    private String descriptions;
    private String category;
    
    @NotNull(message = "Price is req")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(nullable = false)
    private Integer price;

    @NotNull(message = "Stock quantity is req")
    @Min(value = 0, message = "Stock cannot be less than zero")
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    // todo relations
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

}
