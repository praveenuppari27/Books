package com.booksApi.Books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksApi.Books.entity.Book;

public interface BookRepository extends JpaRepository<Book , Long> {


}
