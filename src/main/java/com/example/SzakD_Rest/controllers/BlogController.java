package com.example.SzakD_Rest.controllers;



import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.services.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BlogController {

	private final BlogService blogService;

	
	BlogController(BlogService b){
		this.blogService = b;
	}
	
	@GetMapping("/blogs")
	List<Blog> all(){
		return blogService.getAllBlogs();
	}

	@GetMapping("/blogs/{id}")
	Blog findById(@PathVariable Long id){
		return blogService.findById(id);
	}

	@PostMapping("/blogs")
	Blog newBlog(@RequestBody Blog b){
		return blogService.newBlog(b);
	}

	@PutMapping("/blogs/{id}")
	Blog updateBlog(@RequestBody Blog newBlog, @RequestParam Long id){
		return blogService.updateBlog(newBlog, id);
	}

	@DeleteMapping("/blogs/{id}")
	void deleteBlog(@PathVariable Long id){
		blogService.deleteBlog(id);
	}



	
	
}
