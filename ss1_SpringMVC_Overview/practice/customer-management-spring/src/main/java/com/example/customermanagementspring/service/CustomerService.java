package com.example.customermanagementspring.service;

import com.example.customermanagementspring.model.Customer;
import com.example.customermanagementspring.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
