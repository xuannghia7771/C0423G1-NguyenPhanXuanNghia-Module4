package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void delete(String id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public Product findById(String id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Transactional
    @Override
    public void update(String id, Product product) {
        Product product1 = findById(id);
        entityManager.merge(product1);
        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductDescription(product.getProductDescription());
        product1.setProductPublisher(product.getProductPublisher());
    }

    @Override
    public List<Product> searchByName(String name) {
        name = "%" + name + "%";
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.productName like : name", Product.class);
        query.setParameter("name",name);
        return query.getResultList();
    }
}
