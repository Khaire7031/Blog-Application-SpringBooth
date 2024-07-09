package com.pdk.blog.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdk.blog.app.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}