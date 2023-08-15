package com.example.sandwichspice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class CondimentController {
    @GetMapping("")
    public String home(){
        return "index";
    }
    @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("condiment", Arrays.toString(condiment));
        return "redirect:/home";
    }
//    public String save(@RequestParam("condiment") String[] condiment, Model model) {
//        model.addAttribute("condiment", Arrays.toString(condiment));
//        return "index";
//    }
}
