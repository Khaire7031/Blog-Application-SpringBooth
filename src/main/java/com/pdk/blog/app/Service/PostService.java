package com.pdk.blog.app.Service;

import com.pdk.blog.app.Payloads.PostDto;
import com.pdk.blog.app.Payloads.PostResponse;

import java.util.List;

public interface PostService {

    // Create Post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // Update
    PostDto updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // All post
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String shortDirection);

    // get Single Post
    PostDto getPostById(Integer postId);

    // Get All post By category
    List<PostDto> getPostsByCategory(Integer categoryId);

    // Get All post By user
    List<PostDto> getPostByUser(Integer userId);

    // Search Post
    List<PostDto> searchPost(String keyword);
}
