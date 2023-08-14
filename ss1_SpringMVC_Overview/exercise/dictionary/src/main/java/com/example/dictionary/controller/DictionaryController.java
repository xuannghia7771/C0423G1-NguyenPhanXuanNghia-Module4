package com.example.dictionary.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class DictionaryController {
    @GetMapping("")
    public String showForm(){
        return "index";
    }
    @PostMapping("/home/index")
    public String translate(Model model, @RequestParam String input){
        String result = null;
        String[] vietnamese = {"con chim", "con cho", "con meo"};
        String[] english = {"bird", "dog", "cat"};
        for (int i = 0; i < vietnamese.length; i++) {
            if (input.equals(vietnamese[i])){
                result = english[i];
            } else if (input.equals(english[i])) {
                result = vietnamese[i];
            }
        }
        model.addAttribute("result",result);
        return "index";
    }
}
