package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ProductController {
    @Autowired
    private IProductService service;
    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = service.getAll();
        model.addAttribute("productList",productList);
        return "list";
    }
}
