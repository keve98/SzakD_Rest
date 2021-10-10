package com.example.SzakD_Rest.controllers;


import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.entities.Post;
import com.example.SzakD_Rest.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {


	private final PostService postService;

	public  PostController(PostService s){
		this.postService = s;
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}


	@GetMapping("/posts/{id}")
	Post findById(@PathVariable Long id){
		return postService.findById(id);
	}

	@PostMapping("/posts")
	Post newBlog(@RequestBody Post p){
		return postService.newPost(p);
	}

	@PutMapping("/posts/{id}")
	Post updateBlog(@RequestBody Post newPost, @RequestParam Long id){
		return postService.updatePost(newPost, id);
	}

	@DeleteMapping("/posts/{id}")
	void deleteBlog(@PathVariable Long id){
		postService.deletePost(id);
	}


}
