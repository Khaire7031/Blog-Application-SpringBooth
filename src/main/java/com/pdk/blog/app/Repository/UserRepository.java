package com.pdk.blog.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdk.blog.app.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}