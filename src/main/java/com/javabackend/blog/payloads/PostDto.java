package com.javabackend.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.javabackend.blog.entities.Category;
import com.javabackend.blog.entities.Comment;
import com.javabackend.blog.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	private Integer postId;
		
	private String title;
	
	private String content;
	
	private String imagename;
	
	private Date addedDate;
	

	private CategoryDto category;
	

	private UserDto user;
	
	private Set<Comment> comments = new HashSet<>();
	
}
