package com.example.blog_webservice_spring_boot.controller;

import com.example.blog_webservice_spring_boot.model.Blog;
import com.example.blog_webservice_spring_boot.model.Category;
import com.example.blog_webservice_spring_boot.service.IBlogService;
import com.example.blog_webservice_spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        List<Blog> blogList = blogService.findAllBlog();
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
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> search(@PathVariable String name){
        List<Blog> blogList = blogService.searchName(name);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> searchBlog(@RequestParam String searchTitle, @RequestParam int page){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Blog> blogPage = blogService.searchByTitle(pageable, searchTitle);
        if (blogPage != null){
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
