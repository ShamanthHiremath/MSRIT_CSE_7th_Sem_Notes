package com.example.BookCrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class Book {
    @Id
    private String id;
    @Column
    private String author;
    @Column
    private String publisher;
	public Book()
	{
		
	}
    public Book(String string, String string2, String string3) {
        id=string;
		author=string2;
		publisher=string3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

