package com.example.SzakD_Rest.entities;

import javax.persistence.*;


@Entity
public class HasAuthor {
	
	@Id
	@GeneratedValue
	private Long Id;
	private String author;
	

	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		this.Id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
