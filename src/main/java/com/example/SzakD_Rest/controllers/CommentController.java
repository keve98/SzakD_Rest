package com.example.SzakD_Rest.controllers;

import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.entities.Comment;
import com.example.SzakD_Rest.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CommentController {
	

	private final CommentService commentService;

	
	CommentController(CommentService s){
		commentService = s;
	}
	
	@GetMapping("/comments")
	public List<Comment> all(){
		return  commentService.getAllComments();
	}

	@GetMapping("/comments/{id}")
	Comment findById(@PathVariable Long id){
		return commentService.findById(id);
	}

	@PostMapping("/comments")
	Comment newComment(@RequestBody Comment c){
		return commentService.newComment(c);
	}

	@PutMapping("/comments/{id}")
	Comment updateBlog(@RequestBody Comment newComment, @RequestParam Long id){
		return commentService.updateComment(newComment, id);
	}

	@DeleteMapping("/comments/{id}")
	void deleteBlog(@PathVariable Long id){
		commentService.deleteComment(id);
	}


}
