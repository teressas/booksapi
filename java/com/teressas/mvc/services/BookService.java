package com.teressas.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teressas.mvc.models.Book;
import com.teressas.mvc.repositories.BookRepository;

@Service
public class BookService {
	
	 private final BookRepository bookRepo;
	  
	 public BookService(BookRepository bookRepo) {
	        this.bookRepo = bookRepo;
	    }
	    
	 // returns all books
	 public List<Book> allBooks() {
		 return bookRepo.findAll();
		 
	 }
	 
	 // creates a book
	 public Book addBook(Book book) {
		 // id & createdAT &updatedAt : NULL
		 // MySQL will create them automatically
		 return bookRepo.save(book);
	 }
	 
	 public Book findOne(Long id) {
			Optional<Book> optionalBook = bookRepo.findById(id);
			if(optionalBook.isPresent()) {
				return optionalBook.get(); // optionalBook.get() gives you movie
			}else {
				return null;
			}		
		}
		
		public Book editBook(Long id, String title, String description, String language, Integer numberOfPages) {
			Book oldBook = this.findOne(id);
			oldBook.setTitle(title);
			oldBook.setDescription(description);
			oldBook.setLanguage(language);
			return bookRepo.save(oldBook);
		}
		
		public void deleteBook(Long id) {
			bookRepo.deleteById(id);
		}

}
