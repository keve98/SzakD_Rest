package com.example.SzakD_Rest.entities;


import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;


@Entity
@SessionScoped
@ManagedBean(name="blogEntity")
public class Blog {

	@Id
	@GeneratedValue
	private Long Id;
	
	private String title;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private List<Post> posts;

	public Blog(){
		this.title = "";
	}

	public void addPost(Post p){
		posts.add(p);
	}

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
		if(posts == null){
			posts = new ArrayList<Post>();
		}
		return posts;
	}
}
