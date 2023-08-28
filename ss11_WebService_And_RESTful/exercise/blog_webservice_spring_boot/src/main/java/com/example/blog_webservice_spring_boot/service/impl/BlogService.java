package com.example.blog_webservice_spring_boot.service.impl;

import com.example.blog_webservice_spring_boot.model.Blog;
import com.example.blog_webservice_spring_boot.repository.IBlogRepository;
import com.example.blog_webservice_spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> searchByBlogTitle(Pageable pageable, String searchBlogTitle) {
        return blogRepository.findBlogByBlogTitleContaining(pageable, searchBlogTitle);
    }
}
