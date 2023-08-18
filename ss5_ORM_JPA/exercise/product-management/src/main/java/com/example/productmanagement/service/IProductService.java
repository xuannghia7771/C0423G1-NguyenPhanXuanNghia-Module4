package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void create(Product product);

    void delete(String id);

    Product findById(String id);

    void update(String id, Product product);

    List<Product> searchByName(String name);
}
