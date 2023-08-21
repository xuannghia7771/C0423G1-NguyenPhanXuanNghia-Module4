package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void create(Product product);

    void delete(String id);

    Product findById(String id);

    void update(String id, Product product);

    List<Product> searchByName(String name);
}
