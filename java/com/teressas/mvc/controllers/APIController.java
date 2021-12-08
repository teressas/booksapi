package com.teressas.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teressas.mvc.models.Book;
import com.teressas.mvc.services.BookService;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/findAll")
	public List<Book> findAllBooks(){
		return bookService.allBooks();
	}
	
	@PostMapping("/books")
	public Book processCreateBook(
			@RequestParam("title") String title, 
			@RequestParam("description") String description, 
			@RequestParam("language") String language, 
			@RequestParam("numberOfPages") Integer numberOfPages
			) {
		Book newBook = new Book(title, description, language, numberOfPages);
		return bookService.addBook(newBook);
	}
	
	@GetMapping("/books/{id}")
	public Book findOneBook(@PathVariable("id")Long id) {
		return bookService.findOne(id);
	}
	
	@PutMapping("/books/{id}/edit")
	public Book processUpdateBook(@PathVariable("id")Long id,
			@RequestParam("title") String title, 
			@RequestParam("description") String description, 
			@RequestParam("language") String language, 
			@RequestParam("numberOfPages") Integer numberOfPages
			) {
		return bookService.editBook(id, title, description, language, numberOfPages);
	}
	
	@DeleteMapping("/books/{id}")
	public void processDeleteBook(@PathVariable("id")Long id) {
		bookService.deleteBook(id);
	}
	


	
}
