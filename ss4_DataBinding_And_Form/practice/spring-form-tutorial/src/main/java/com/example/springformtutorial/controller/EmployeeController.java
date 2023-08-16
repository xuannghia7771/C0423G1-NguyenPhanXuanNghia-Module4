package com.example.springformtutorial.controller;

import com.example.springformtutorial.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.WebServlet;

@Controller
@WebServlet()
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping(value = "/showForm")
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        return "employee/create";
    }
    @PostMapping(value = "/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap modelMap){
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        modelMap.addAttribute("id", employee.getId());
        return "employee/info";
    }
}
