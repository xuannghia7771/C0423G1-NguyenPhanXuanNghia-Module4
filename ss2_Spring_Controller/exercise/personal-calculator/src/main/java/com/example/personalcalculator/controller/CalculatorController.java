package com.example.personalcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class CalculatorController {
    @GetMapping("")
    public String get() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("calculate") String calculate,
                            @RequestParam(name = "firstOperand", required = false, defaultValue = "0") Double firstOperand,
                            @RequestParam(name = "secondOperand", required = false, defaultValue = "0") Double secondOperand,
                            RedirectAttributes redirectAttributes) {
        double result = 0;
        switch (calculate) {
            case "Addition(+)":
                result = firstOperand + secondOperand;
                break;
            case "Subtraction(-)":
                result = firstOperand - secondOperand;
                break;
            case "Multiplication(x)":
                result = firstOperand * secondOperand;
                break;
            default:
                result = firstOperand / secondOperand;
                break;
        }
        redirectAttributes.addFlashAttribute("result", result);
        redirectAttributes.addFlashAttribute("first", firstOperand);
        redirectAttributes.addFlashAttribute("second", secondOperand);
        return "redirect:/home";
    }
}
