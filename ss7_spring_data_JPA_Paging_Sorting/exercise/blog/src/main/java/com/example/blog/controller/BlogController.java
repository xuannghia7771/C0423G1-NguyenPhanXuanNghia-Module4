package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "",required = false) String searchTitle) {
        Pageable pageable = PageRequest.of(page,2);
        Page<Blog> blogPage = blogService.searchByTitle(pageable,searchTitle);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("searchTitle",searchTitle);
        return "list";
    }
    @ModelAttribute("category")
    public List<Category> getBlogCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/save")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.saveNewBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Create Successfully!");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/edit")
        public String showEditForm(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            model.addAttribute("message", "BLOG NOT EXIST");
        } else {
            model.addAttribute("blog", blog);
        }
        return "edit";
    }
    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("message", "EDIT SUCCESSFULLY");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "DELETE SUCCESSFULLY");
        return "redirect:/blog";
    }
}
