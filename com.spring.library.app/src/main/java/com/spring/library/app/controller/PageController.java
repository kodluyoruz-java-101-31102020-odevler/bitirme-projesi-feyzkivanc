package com.spring.library.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.library.app.context.Context;
import com.spring.library.app.dao.entity.Book;
import com.spring.library.app.service.BookService;

@Controller
@RequestMapping("/pages")
public class PageController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
		List<Book> book = bookService.getAllBookList();
		model.addAttribute("book", book);
		
		return "thyme_book_list";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getBookSavePage(Context bookContext) {
		
		return "thyme_book_save";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
    public String save(Context bookContext, BindingResult result, Model model) {
        
		
		bookService.save(bookContext);
        
		model.addAttribute("book", bookService.getAllBookList());
        
        return "thyme_book_list";
    }

	@RequestMapping(value = "/book/search", method = RequestMethod.POST)
	public String searchBookList(Context bookContext, BindingResult result, Model model) {
		
		List<Book> book = bookService.searchBookList(bookContext);
		model.addAttribute("book", book);
		
		return "thyme_books_list";
	}
}
