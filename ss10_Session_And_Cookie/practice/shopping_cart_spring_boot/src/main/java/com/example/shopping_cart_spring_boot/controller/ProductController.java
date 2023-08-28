package com.example.shopping_cart_spring_boot.controller;

import com.example.shopping_cart_spring_boot.model.Cart;
import com.example.shopping_cart_spring_boot.model.Product;
import com.example.shopping_cart_spring_boot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return "/error_404";
        }
        if (action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable long id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("products", productService.findById(id));
        return "product-detail";
    }
}
