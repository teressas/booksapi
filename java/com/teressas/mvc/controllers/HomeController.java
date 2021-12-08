package com.teressas.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.teressas.mvc.models.Book;
import com.teressas.mvc.services.BookService;

@Controller
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	// SHOW ONE
		@GetMapping("/books/{id}")
		public String showOneBook(@PathVariable("id")Long id, Model model) {
			Book books = bookService.findOne(id);
			model.addAttribute("books", books);
			return "showOneBook.jsp";
		}
	
	// FIND ALL
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "dashboard.jsp";
	}
	
	
	// CREATE
//	@GetMapping("/books/create")
//	public String createForm(@ModelAttribute("newBook")Book newBook) {
//		//
//		return "createForm.jsp";
//	}
//	
//	@PostMapping("/books/create")
//	public String procesCreateForm
//	

}
