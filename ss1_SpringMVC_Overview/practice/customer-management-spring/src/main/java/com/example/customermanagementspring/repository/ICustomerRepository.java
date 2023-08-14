package com.example.customermanagementspring.repository;

import com.example.customermanagementspring.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
}
