package com.pdk.blog.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdk.blog.app.Entity.*;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    // Search From DataBase
    List<Post> findByTitleContaining(String title);

}
