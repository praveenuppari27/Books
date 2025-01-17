package com.booksApi.Books.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Isbn;
	private String Title;
	private String Author;
	private Integer YearOfPublication;
	private String Publisher;
	public Book(Long id, String isbn, String title, String author, Integer yearOfPublication, String publisher) {
		super();
		Id = id;
		Isbn = isbn;
		Title = title;
		Author = author;
		YearOfPublication = yearOfPublication;
		Publisher = publisher;
	}

	public Book() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String isbn) {
		Isbn = isbn;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public Integer getYearOfPublication() {
		return YearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		YearOfPublication = yearOfPublication;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}


	@Override
	public String toString() {
		return "Book [Id=" + Id + ", Isbn=" + Isbn + ", Title=" + Title + ", Author=" + Author + ", YearOfPublication="
				+ YearOfPublication + ", Publisher=" + Publisher + ", getId()=" + getId() + ", getIsbn()=" + getIsbn()
				+ ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor() + ", getYearOfPublication()="
				+ getYearOfPublication() + ", getPublisher()=" + getPublisher() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
