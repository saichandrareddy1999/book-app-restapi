package com.stackroute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@Column(length=64)
	private String id;
	private String title;
	private String authors;
	private String description;
	public Book() {
		
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", description=" + description + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Book(String id, String title, String authors, String description) {
		
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.description = description;
	}
}