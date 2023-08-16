package com.example.emailconfiguration.controller;

import com.example.emailconfiguration.model.MailConfig;
import com.example.emailconfiguration.service.IMailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailConfigController {
    @Autowired
    private IMailConfigService service;
    @GetMapping("")
    public String showList(@ModelAttribute MailConfig mailConfig, Model model){
        List<MailConfig> mailConfigList  = service.getAll();
        model.addAttribute("list",mailConfigList);
        return "list";
    }
}
