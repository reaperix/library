package com.library.service;

import java.util.Map;

import com.library.model.Book;

public interface BookService {
	public Map<String, Book> getAllBooks();
	public Book getBookById(String id);
	public Book addBook(Book newBook);
	public void removeBook(String id);
	public Book updateBook(String id, Book book);
}
