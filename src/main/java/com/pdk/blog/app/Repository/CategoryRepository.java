package com.pdk.blog.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdk.blog.app.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
