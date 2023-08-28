package com.example.blog_webservice_spring_boot.repository;

import com.example.blog_webservice_spring_boot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findBlogByBlogTitleContaining(Pageable pageable, String searchBlogTitle);
}
