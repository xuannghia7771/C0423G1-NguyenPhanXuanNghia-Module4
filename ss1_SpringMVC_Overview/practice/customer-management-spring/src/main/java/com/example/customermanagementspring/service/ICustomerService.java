package com.example.customermanagementspring.service;

import com.example.customermanagementspring.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
}
