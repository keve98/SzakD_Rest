package com.example.SzakD_Rest.controllers;



import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.entities.HasAuthor;
import com.example.SzakD_Rest.services.HasAuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class HasAuthorController {

	private final HasAuthorService hasAuthorService;


	HasAuthorController(HasAuthorService s){
		hasAuthorService = s;
	}
	
	@GetMapping("/hasauthors")
	public List<HasAuthor> getAllHasAuthors(){
		return hasAuthorService.getAllHasAuthors();
	}


	@GetMapping("/hasauthors/{id}")
	HasAuthor findById(@PathVariable Long id){
		return hasAuthorService.findById(id);
	}

	@PostMapping("/hasauthors")
	HasAuthor newBlog(@RequestBody HasAuthor h){
		return hasAuthorService.newHasAuthor(h);
	}

	@PutMapping("/hasauthors/{id}")
	HasAuthor updateBlog(@RequestBody HasAuthor newHasAuthor, @RequestParam Long id){
		return hasAuthorService.updateHasAuthor(newHasAuthor, id);
	}

	@DeleteMapping("/hasauthors/{id}")
	void deleteBlog(@PathVariable Long id){
		hasAuthorService.deleteHasAuthor(id);
	}
}
