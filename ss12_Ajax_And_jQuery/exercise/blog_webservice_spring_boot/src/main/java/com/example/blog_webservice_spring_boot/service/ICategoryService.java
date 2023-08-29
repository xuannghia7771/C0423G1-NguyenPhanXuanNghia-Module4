package com.example.blog_webservice_spring_boot.service;

import com.example.blog_webservice_spring_boot.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
