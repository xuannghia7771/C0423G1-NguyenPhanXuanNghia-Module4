package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService service;
    @GetMapping("")
    public String showList(Model model) {
        List<Blog> blogList = service.findAll();
        model.addAttribute("blogList",blogList);
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/save")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        service.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create Successfully!");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/edit")
        public String showEditForm(Model model, @PathVariable int id) {
        Blog blog = service.findById(id);
        if (blog == null) {
            model.addAttribute("message", "BLOG NOT EXIST");
        } else {
            model.addAttribute("blog", blog);
        }
        return "edit";
    }
    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        service.save(blog);
        redirectAttributes.addFlashAttribute("message", "EDIT SUCCESSFULLY");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model) {
        Blog blog = service.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        service.delete(id);
        redirectAttributes.addFlashAttribute("mess", "xoa thanh cong");
        return "redirect:/blog";
    }
}
