package com.example.blog_webservice_spring_boot.repository;

import com.example.blog_webservice_spring_boot.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchTitle);

    @Modifying
    @Transactional
    @Query(value = "insert into blog(author, content, create_date, title, category_id) value(:author, :content, :createDate, :title, :category)", nativeQuery = true)
    void saveNewBlog(@Param("author") String author, @Param("content") String content, @Param("createDate") LocalDate createDate, @Param("title") String title, @Param("category") int categoryName);

    @Modifying
    @Transactional
    @Query(value = "delete from blog where blog_id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update blog set title = :title, content = :content, create_date = :createDate, author = :author, category_id = :category where blog_id = :id", nativeQuery = true)
    void updateBlog(@Param("id") int id, @Param("title") String title, @Param("content") String content, @Param("createDate") LocalDate createDate, @Param("author") String author, @Param("category") int categoryId);

    @Query(value = "select * from blog where category_id =:id", nativeQuery = true)
    List<Blog> findByCategory(@Param("id") int id);

    @Query(value = "select * from blog where title like :title", nativeQuery = true)
    List<Blog> findBlogByTitle(@Param("title") String title);
}
