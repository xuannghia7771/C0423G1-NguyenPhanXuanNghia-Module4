package com.example.blog_webservice_spring_boot.service;

import com.example.blog_webservice_spring_boot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> searchByBlogTitle(Pageable pageable, String searchTitle);
}
