package com.example.blog_webservice_spring_boot.service.impl;

import com.example.blog_webservice_spring_boot.repository.ICategoryRepository;
import com.example.blog_webservice_spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
}
