package com.example.practise.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practise.dto.OrderItemRequest;
import com.example.practise.dto.OrderRequest;
import com.example.practise.entities.Order;
import com.example.practise.entities.OrderItem;
import com.example.practise.entities.Product;
import com.example.practise.repositries.OrderRepository;
import com.example.practise.repositries.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    // 1. Added 'final' keyword so Lombok injects these via Constructor properly
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest) {
        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for (OrderItemRequest orderItemRequest : orderRequest.getItems()) {
            Product product = productRepository.findById(orderItemRequest.getProductId())
                    .orElseThrow(
                            () -> new RuntimeException("Product not found by id: " + orderItemRequest.getProductId()));

            // Check the product stock
            if (product.getStockQuantity() < orderItemRequest.getQuantity()) {
                // 3. Fixed missing semicolon here
                throw new RuntimeException("Not enough product in stock: " + orderItemRequest.getProductId());
            }

            // Calculate total price using BigDecimal
            BigDecimal price = BigDecimal.valueOf(product.getPrice())
                    .multiply(BigDecimal.valueOf(orderItemRequest.getQuantity()));

            totalPrice = totalPrice.add(price);

            totalPrice = totalPrice.add(price);

            // Deduct product stock quantity
            product.setStockQuantity(product.getStockQuantity() - orderItemRequest.getQuantity());

            // Note: productRepository.save(product) is optional here because
            // @Transactional automatically dirty-checks and saves entity updates.

            // Build OrderItem mapping back to the main order
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(orderItemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItems.add(orderItem);
        }

        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);

        // 2. Critical Step: Actually save the created order to your database!
        return orderRepository.save(order);
    }
}