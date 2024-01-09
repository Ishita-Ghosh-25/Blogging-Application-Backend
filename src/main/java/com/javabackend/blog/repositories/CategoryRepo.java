package com.javabackend.blog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javabackend.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	
		
}
