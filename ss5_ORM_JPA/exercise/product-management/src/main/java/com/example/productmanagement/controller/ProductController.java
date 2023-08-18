package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = service.getAll();
        model.addAttribute("productList", productList);
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/add")
    public String saveCreation(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        service.create(product);
        redirectAttributes.addFlashAttribute("message", "Create Successfully");
        return "redirect:/product";
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam String id, RedirectAttributes redirectAttributes) {
        service.delete(id);
        redirectAttributes.addFlashAttribute("message", "DELETE SUCCESSFULLY");
        return "redirect:/product";
    }
    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam String id) {
        Product product = service.findById(id);
        if (product == null) {
            model.addAttribute("message", "PRODUCT NOT EXIST");
        } else {
            model.addAttribute("product", product);
        }
        return "edit";
    }
    @PostMapping("/edit")
    public String updateProduct(@RequestParam String id, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        service.update(id, product);
        redirectAttributes.addFlashAttribute("message", "EDIT SUCCESSFULLY");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "detail";
    }
    @PostMapping("/search")
    public String searchByName(@RequestParam String name, Model model){
        List<Product> productList = service.searchByName(name);
        model.addAttribute("productList",productList);
        return "search";
    }
}
