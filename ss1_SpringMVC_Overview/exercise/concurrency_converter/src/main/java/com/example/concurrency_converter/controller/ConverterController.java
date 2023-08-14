package com.example.concurrency_converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("")
    public String showForm(){
        return "index";
    }

    @PostMapping("home/index")
    public String converter(Model model, @RequestParam String select1, @RequestParam String select2, @RequestParam double input){
        double result = 0.0;
        if (select1.equals(select2)){
            result = input;
        }
        if (select1.equals("usd") && select2.equals("vnd")){
            result = 23000*input;
        }
        if (select1.equals("vnd") && select2.equals("usd")){
            result = input/23000;
        }
        model.addAttribute("result",result);
        return "index";
    }
}
