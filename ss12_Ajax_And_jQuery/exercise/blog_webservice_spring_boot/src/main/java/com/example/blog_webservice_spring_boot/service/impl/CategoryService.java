package com.example.blog_webservice_spring_boot.service.impl;

import com.example.blog_webservice_spring_boot.model.Category;
import com.example.blog_webservice_spring_boot.repository.ICategoryRepository;
import com.example.blog_webservice_spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
