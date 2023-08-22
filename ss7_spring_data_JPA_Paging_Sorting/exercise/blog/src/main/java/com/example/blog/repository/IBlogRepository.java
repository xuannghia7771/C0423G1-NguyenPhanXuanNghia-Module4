package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchTitle);


    @Modifying
    @Transactional
    @Query(value = "insert into blog(blog_title, blog_content, blog_author, category_id) value(:title, :content, :author, :category)", nativeQuery = true)
    void saveNewBlog(@Param("title") String title,@Param("content") String content,@Param(("author")) String author,@Param("category") int categoryName);

    @Modifying
    @Transactional
    @Query(value = "delete from blog where blog_id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update blog set blog_title = :title, blog_content = :content, blog_author = :author, category_id = :category where blog_id = :id", nativeQuery = true)
    void updateBlog(@Param("id") int id, @Param("title") String title, @Param("content") String content, @Param("author") String author, @Param("category") int categoryId);
}
