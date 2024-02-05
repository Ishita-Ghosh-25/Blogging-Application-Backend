package com.javabackend.blog.services;

import com.javabackend.blog.payloads.CommentDto;

public interface CommentService{

	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
	
}
