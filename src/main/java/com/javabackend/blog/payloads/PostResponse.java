package com.javabackend.blog.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class PostResponse {
	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	//Total number of records
	private long totalElements;
	//Total Number Of Pages
	private int totalPages;
	
	private boolean lastPage;
	
}
