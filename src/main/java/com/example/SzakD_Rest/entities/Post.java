package com.example.SzakD_Rest.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post extends HasAuthor{
	
	@Id
	@GeneratedValue
	private Long Id;
	private String title;
	private String content;
	@OneToMany
	private List<Comment> comments;
	

	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getComments() {
		if(comments == null){
			comments = new ArrayList<Comment>();
		}
		return comments;
	}


	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
}
