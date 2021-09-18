package com.library.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.model.Book;

@Service
public class BookServiceImpl implements BookService{
	
	private static Map<String, Book> bookMap = new HashMap<>();
	private int nextId = 4;

	static{
	bookMap.put("1", new Book("The Lord of the Rings", "J.R.R Tolkien", 1955));
	bookMap.put("2", new Book("A Tale of Two Cities", "Charles Dickens", 1859));
	bookMap.put("3", new Book("War and Peace", "Leo Tolstoy", 1869));
	}

	@Override
	public Map<String, Book> getAllBooks() {
		
		return bookMap;
	}
	
	@Override
	public Book getBookById(String id) {
		return bookMap.get(id);
	}
	
	@Override
	public Book addBook(Book newBook) {
		bookMap.put(Integer.toString(nextId++), newBook);
		return newBook;
	}
	
	@Override
	public void removeBook(String id) {
		bookMap.remove(id);
	}
	
	@Override
	public Book updateBook(String id, Book book) {
		bookMap.replace(id, book);
		return book;
	}
	
}
