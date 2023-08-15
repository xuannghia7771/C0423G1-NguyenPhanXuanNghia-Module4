package com.example.customermanagementspring.controller;

import com.example.customermanagementspring.model.Customer;
import com.example.customermanagementspring.service.CustomerService;
import com.example.customermanagementspring.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customers", customerList);
        return "list";
    }
}
