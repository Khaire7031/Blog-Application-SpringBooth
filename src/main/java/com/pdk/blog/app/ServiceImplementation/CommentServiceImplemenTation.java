package com.pdk.blog.app.ServiceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdk.blog.app.Entity.Comment;
import com.pdk.blog.app.Entity.Post;
import com.pdk.blog.app.Exception.ResourceNotFoundException;
import com.pdk.blog.app.Payloads.CommentDto;
import com.pdk.blog.app.Repository.CommentRepository;
import com.pdk.blog.app.Repository.PostRepository;
import com.pdk.blog.app.Service.CommentService;

@Service
public class CommentServiceImplemenTation implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ", "postId", postId));

        Comment comment = modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);

        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment ", "comment Id", commentId));
        commentRepository.delete(comment);
    }

}
