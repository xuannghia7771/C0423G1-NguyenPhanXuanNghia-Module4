package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void update(String id, Product product) {
        repository.update(id,product);
    }

    @Override
    public List<Product> searchByName(String name) {
        return repository.searchByName(name);
    }
}
