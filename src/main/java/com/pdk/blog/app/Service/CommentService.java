package com.pdk.blog.app.Service;

import com.pdk.blog.app.Payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);

}
