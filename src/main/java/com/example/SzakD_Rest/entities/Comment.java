package com.example.SzakD_Rest.entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@Entity
@ManagedBean(name = "commentEntity", eager = true)
@SessionScoped
public class Comment extends HasAuthor{
	
	@Id
	@GeneratedValue
	private Long Id;
	private String content;

	public Comment(){
		super();
		content = "";
	}

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
}
