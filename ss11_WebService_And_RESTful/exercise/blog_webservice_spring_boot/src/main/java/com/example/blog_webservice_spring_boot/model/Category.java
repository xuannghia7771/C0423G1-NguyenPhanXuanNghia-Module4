package com.example.blog_webservice_spring_boot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogSet;

    public Category() {

    }

    public Category(int categoryId, String categoryName, Set<Blog> blogSet) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.blogSet = blogSet;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
