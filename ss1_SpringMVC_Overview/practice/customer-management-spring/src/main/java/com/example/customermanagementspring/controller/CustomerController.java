package com.example.customermanagementspring.controller;

import com.example.customermanagementspring.model.Customer;
import com.example.customermanagementspring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
//    public String showList(Model model) {
//        List<Customer> customerList = customerService.getAll();
//        model.addAttribute("customers", customerList);
//        return "list";
//    }

    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customerList = customerService.getAll();
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }
}
