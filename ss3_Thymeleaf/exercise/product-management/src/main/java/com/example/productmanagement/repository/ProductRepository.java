package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Repository
public class ProductRepository implements IProductRepository{
    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product("PD-001","Laptop Dell Insiprison",600.99,"zcxqweqwe zxczxc","Dell"));
        productList.add(new Product("PD-002","Samsung S21 Ultra",2100.99,"Samsung dien thoai","Samsung"));
        productList.add(new Product("PD-003","Oppo Reno 9",1999.99,"San phan dien thoai oppo","Oppo"));
        productList.add(new Product("PD-004","Macbook M1 Pro",2000.99,"San pham cua Apple","Apple"));
        productList.add(new Product("PD-005","Nokia Lumia 520",1235.99,"San pham cua Nokia","Nokia"));
        productList.add(new Product("PD-006","Honda Winner X",1500.99,"San pham cua Honda","Honda"));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }
    public int search(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (Objects.equals(id, productList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void delete(String id) {
        productList.remove(search(id));
    }

    @Override
    public Product findById(String id) {
        for(Product product: productList){
            if (Objects.equals(id,product.getId())){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Product product) {
        productList.set(search(id), product);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().contains(name)){
                products.add(productList.get(i));
            }
        }
        return products;
    }
}
