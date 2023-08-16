package com.example.emailconfiguration.controller;

import com.example.emailconfiguration.model.MailConfig;
import com.example.emailconfiguration.service.IMailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/home")
public class MailController {
    @Autowired
    private IMailConfigService service;
    @GetMapping("/list")
    public String showList(Model model){
        List<MailConfig> mailConfigList = service.getAll();
        model.addAttribute("mailList", mailConfigList);
        return "list";
    }
    @GetMapping("/edit")
    public String detail(@RequestParam int id, Model model) {
        MailConfig mailBox = service.findById(id);
        model.addAttribute("mailBox", mailBox);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute MailConfig mailBox, int id, RedirectAttributes redirectAttributes) {
        service.edit(id, mailBox);
        redirectAttributes.addFlashAttribute("message", "edit successfully");
        return "redirect:/home/list";
    }
}
