package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void create(Product product);

    Product findById(String id);

    void update(String id, Product product);

    void delete(String id);
}
