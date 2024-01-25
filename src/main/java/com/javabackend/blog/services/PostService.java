package com.javabackend.blog.services;

import java.util.List;

import com.javabackend.blog.entities.Post;
import com.javabackend.blog.payloads.PostDto;
import com.javabackend.blog.payloads.PostResponse;

public interface PostService {

	//Create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//Update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//Delete
	void deletePost(Integer postId);
	
	//Get ALL Posts
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//Get a single post
	PostDto getPostById(Integer postId);
	
	//Get All post by Category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//Get All Posts By user
	List<PostDto> getPostByUser(Integer userId);
	
	
	//Search
	List<PostDto> searchPosts(String keyword);
	
	
}
