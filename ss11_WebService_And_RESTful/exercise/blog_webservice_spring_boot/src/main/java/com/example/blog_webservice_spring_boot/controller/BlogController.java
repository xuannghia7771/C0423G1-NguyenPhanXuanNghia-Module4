package com.example.blog_webservice_spring_boot.controller;

import com.example.blog_webservice_spring_boot.model.Blog;
import com.example.blog_webservice_spring_boot.service.IBlogService;
import com.example.blog_webservice_spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "",required = false) String searchBlogTitle) {
        Pageable pageable = PageRequest.of(page,2);
        Page<Blog> blogPage = blogService.searchByBlogTitle(pageable,searchBlogTitle);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("searchBlogTitle",searchBlogTitle);
        return "list";
    }

}
