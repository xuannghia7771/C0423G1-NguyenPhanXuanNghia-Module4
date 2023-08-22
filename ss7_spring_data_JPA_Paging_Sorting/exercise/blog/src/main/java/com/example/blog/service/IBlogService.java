package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Blog findById(int id);


    Page<Blog> searchByTitle(Pageable pageable, String searchTitle);

    void saveNewBlog(Blog blog);

    void delete(int id);

    void updateBlog(Blog blog);
}
