package com.example.shopping_cart_spring_boot.service;

import com.example.shopping_cart_spring_boot.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
