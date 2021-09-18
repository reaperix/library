package com.library.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.library.model.Book;
import com.library.service.BookServiceImpl;

@Controller
@ResponseBody
public class BookController {
	
	@Autowired
	BookServiceImpl bookService;
	
	@GetMapping("/library")
	public Map<String, Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/library/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
		Book book = bookService.getBookById(id);
		
		if(book == null) {
			return new ResponseEntity<Book> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book> (book, HttpStatus.OK);
	}
	
	@PostMapping("/library/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Book addBook(@RequestBody Book newBook) {
		return bookService.addBook(newBook);
	}
	
	@PostMapping("/library/remove/{id}")
	public ResponseEntity<Book> removeBook(@PathVariable("id") String id) {
		Book book = bookService.getBookById(id);
		
		if(book == null) {
			return new ResponseEntity<Book> (HttpStatus.NOT_FOUND);
		}
		bookService.removeBook(id);
		return new ResponseEntity<Book> (book, HttpStatus.OK);
	}
	
	@PostMapping("/library/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") String id, @RequestBody Book newBook) {
		Book oldBook = bookService.getBookById(id);
		
		if(oldBook == null) {
			return new ResponseEntity<Book> (HttpStatus.NOT_FOUND);
		}
		bookService.updateBook(id, newBook);
		return new ResponseEntity<Book> (newBook, HttpStatus.OK);
	}
}
