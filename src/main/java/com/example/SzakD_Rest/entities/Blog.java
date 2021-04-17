package com.example.SzakD_Rest.entities;


import java.util.List;

import javax.persistence.*;


@Entity
public class Blog {

	@Id
	@GeneratedValue
	private Long Id;
	
	private String title;
	@OneToMany
	private List<Post> posts;


	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		this.Id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String toString(){
		return "["+this.Id+"] " + this.getTitle();
	}
	
}
