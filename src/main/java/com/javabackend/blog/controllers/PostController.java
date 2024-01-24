package com.javabackend.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javabackend.blog.entities.Post;
import com.javabackend.blog.payloads.ApiResponse;
import com.javabackend.blog.payloads.PostDto;
import com.javabackend.blog.payloads.PostResponse;
import com.javabackend.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//Create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto, 
			@PathVariable Integer userId,
			@PathVariable Integer categoryId)
	{
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	//Get By User
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> posts = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	
	//Get By Category
		@GetMapping("/category/{categoryId}/posts")
		public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
			List<PostDto> posts = this.postService.getPostByCategory(categoryId);
			return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		}
		
	//Get All Posts
		@GetMapping("/posts")
		public ResponseEntity<PostResponse> getAllPost(
				@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
				@RequestParam(value = "pageSize", defaultValue = "10", required= false) Integer pageSize,
				@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
				@RequestParam(value= "sortDir", defaultValue = "asc", required = false) String sortDir
				){
			PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
			return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
		}
		
	//Get Posts By Id
		@GetMapping("/posts/{postId}")
		public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
		{
			PostDto postDto = this.postService.getPostById(postId);
			return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
		}
		
		//Delete Post
		@DeleteMapping("/posts/{postId}")
		public ApiResponse deletePost(@PathVariable Integer postId) {
			this.postService.deletePost(postId);
			return new ApiResponse("Post is successfully deleted!",true);
		}
		//Update 
		@PutMapping("/posts/{postId}")
		public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
			PostDto updatePost = this.postService.updatePost(postDto, postId);
			return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
		}
		
		
		
}
