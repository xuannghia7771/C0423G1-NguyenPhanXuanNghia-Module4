package com.example.blog_webservice_spring_boot.controller;

import com.example.blog_webservice_spring_boot.model.Blog;
import com.example.blog_webservice_spring_boot.model.Category;
import com.example.blog_webservice_spring_boot.service.IBlogService;
import com.example.blog_webservice_spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class RestBlogController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> showBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> categoryList() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @GetMapping("/findByCategory/{id}")
    public ResponseEntity<List<Blog>> showBlogOfCategory(@PathVariable int id) {
        List<Blog> blogList = blogService.findByCategory(id);
        if (blogList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
