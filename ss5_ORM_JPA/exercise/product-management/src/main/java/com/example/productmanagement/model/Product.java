package com.example.productmanagement.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private String id;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String productPublisher;

    public Product() {

    }

    public Product(String id, String productName, double productPrice, String productDescription, String productPublisher) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productPublisher = productPublisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPublisher() {
        return productPublisher;
    }

    public void setProductPublisher(String productPublisher) {
        this.productPublisher = productPublisher;
    }
}
