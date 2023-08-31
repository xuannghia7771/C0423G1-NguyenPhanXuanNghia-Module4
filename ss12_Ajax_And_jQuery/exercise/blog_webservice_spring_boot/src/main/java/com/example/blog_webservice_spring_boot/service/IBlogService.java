package com.example.blog_webservice_spring_boot.service;


import com.example.blog_webservice_spring_boot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Blog findById(int id);

    Page<Blog> searchByTitle(Pageable pageable, String searchTitle);

    void saveNewBlog(Blog blog);

    void delete(int id);

    void updateBlog(Blog blog);

    List<Blog> findAllBlog();

    List<Blog> findByCategory(int id);
    List<Blog> searchName(String name);
}
