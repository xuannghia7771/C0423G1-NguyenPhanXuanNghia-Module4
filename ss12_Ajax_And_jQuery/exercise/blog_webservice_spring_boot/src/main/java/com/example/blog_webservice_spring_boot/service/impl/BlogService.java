package com.example.blog_webservice_spring_boot.service.impl;

import com.example.blog_webservice_spring_boot.model.Blog;
import com.example.blog_webservice_spring_boot.repository.IBlogRepository;
import com.example.blog_webservice_spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }
    @Override
    public Page<Blog> searchByTitle(Pageable pageable, String searchTitle) {
        return blogRepository.findBlogByTitleContaining(pageable, searchTitle);
    }

    @Override
    public void saveNewBlog(Blog blog) {
        blogRepository.saveNewBlog(blog.getAuthor(), blog.getContent(), blog.getCreateDate(), blog.getTitle(), blog.getCategory().getCategoryId());
    }
    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.updateBlog(blog.getBlogId(), blog.getTitle(),blog.getContent(), blog.getCreateDate(), blog.getAuthor(), blog.getCategory().getCategoryId());
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByCategory(int id) {
        return blogRepository.findByCategory(id);
    }
}
