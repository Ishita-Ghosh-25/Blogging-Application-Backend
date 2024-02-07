package com.javabackend.blog.services.impl;

import com.javabackend.blog.payloads.CommentDto;
import com.javabackend.blog.services.CommentService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabackend.blog.entities.Comment;
import com.javabackend.blog.entities.Post;
import com.javabackend.blog.exceptions.ResourceNotFoundException;
import com.javabackend.blog.payloads.CommentDto;
import com.javabackend.blog.repositories.CommentRepo;
import com.javabackend.blog.repositories.PostRepo;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class );
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "comment id", commentId));
		this.commentRepo.delete(comment);
	}

}
