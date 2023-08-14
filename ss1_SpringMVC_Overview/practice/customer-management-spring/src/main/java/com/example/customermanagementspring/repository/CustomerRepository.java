package com.example.customermanagementspring.repository;

import com.example.customermanagementspring.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
        customerList.add(new Customer(2, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Đà Nẵng"));
        customerList.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.vn", "Hà Nội"));
        customerList.add(new Customer(4, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sài Gòn"));
        customerList.add(new Customer(5, "CodeGym", "codegym@codegym.vn", "Việt Nam"));
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
