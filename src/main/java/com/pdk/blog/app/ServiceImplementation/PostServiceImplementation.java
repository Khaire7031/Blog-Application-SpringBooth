package com.pdk.blog.app.ServiceImplementation;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pdk.blog.app.Entity.Category;
import com.pdk.blog.app.Entity.Post;
import com.pdk.blog.app.Entity.User;
import com.pdk.blog.app.Exception.ResourceNotFoundException;
import com.pdk.blog.app.Payloads.PostDto;
import com.pdk.blog.app.Payloads.PostResponse;
import com.pdk.blog.app.Repository.CategoryRepository;
import com.pdk.blog.app.Repository.PostRepository;
import com.pdk.blog.app.Repository.UserRepository;
import com.pdk.blog.app.Service.PostService;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " id", userId));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        System.out.println("Post Dto Impl : " + postDto.toString());
        Post post = new Post(); // modelMapper.map(postDto, Post.class);
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        Post savePost = postRepository.save(post);
        return modelMapper.map(savePost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // Update post with postDto data
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setAddDate(new Date());
        post.setImageName(postDto.getImageName());

        Post updatePost = postRepository.save(post);
        return modelMapper.map(updatePost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        postRepository.delete(post);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        PageRequest p = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> pagePosts = postRepository.findAll(p);

        List<Post> allPosts = pagePosts.getContent();

        List<PostDto> postDtos = allPosts.stream().map(post -> modelMapper.map(post, PostDto.class))
                .toList();

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePosts.getNumber());
        postResponse.setPagesize(pagePosts.getSize());
        postResponse.setTotalElement(pagePosts.getTotalElements());
        postResponse.setTotalPage(pagePosts.getTotalPages());
        postResponse.setLastPage(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        List<Post> allPost = postRepository.findByCategory(category);
        List<PostDto> allPostByCategory = allPost.stream().map(post -> modelMapper.map(post, PostDto.class)).toList();
        return allPostByCategory;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " id", userId));

        List<Post> posts = postRepository.findByUser(user);
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).toList();

        return postDtos;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        List<Post> posts = postRepository.findByTitleContaining(keyword);
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).toList();
        return postDtos;
    }

}
