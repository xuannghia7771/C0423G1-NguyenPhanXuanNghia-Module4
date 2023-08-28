package com.example.blog_webservice_spring_boot.repository;

import com.example.blog_webservice_spring_boot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
