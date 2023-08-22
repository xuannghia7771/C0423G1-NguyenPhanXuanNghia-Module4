package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository repository;

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> searchByTitle(Pageable pageable, String searchTitle) {
        return repository.findBlogByTitleContaining(pageable,searchTitle);
    }
//    int id, String title, String content, String author, Category category
    @Override
    public void saveNewBlog(Blog blog) {
        repository.saveNewBlog(blog.getTitle(),blog.getContent(),blog.getAuthor(),blog.getCategory().getId());
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void updateBlog(Blog blog) {
        repository.updateBlog(blog.getId(), blog.getTitle(),blog.getContent(), blog.getAuthor(), blog.getCategory().getId());
    }

}
