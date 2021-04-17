package com.example.SzakD_Rest.entities;

import javax.persistence.*;

@Entity
public class Comment extends HasAuthor{
	
	@Id
	@GeneratedValue
	private Long Id;

	private String content;


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	} 
	
	@Override
	public String toString() {
		return "Comment:	 " + this.content;
		
	}
}
