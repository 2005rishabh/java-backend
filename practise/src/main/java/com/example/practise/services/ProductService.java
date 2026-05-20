package com.example.practise.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practise.entities.Product;
import com.example.practise.repositries.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product exProduct = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found by id" + id));

        exProduct.setName(product.getName());
        exProduct.setDescriptions(product.getDescriptions());
        exProduct.setCategory(product.getCategory());
        exProduct.setPrice(product.getPrice());
        exProduct.setStockQuantity(product.getStockQuantity());

        return productRepository.save(exProduct);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found by id" + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
