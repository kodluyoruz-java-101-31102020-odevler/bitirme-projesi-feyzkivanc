package library.spring.app.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.spring.app.dao.entity.Book;
import library.spring.app.service.BookService;


@RestController
@RequestMapping("/library")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book findByid(@PathVariable("id") Long id) {
		
		return bookService.findByid(id);
	}
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public List<Book> getAllBookList() {
		
		return bookService.getAllBookList();
	}
	
	@RequestMapping(value = "/book/search", method = RequestMethod.POST)
	public  List<Book> searchBooksList(@RequestBody Context bookContext) {
			
		return bookService.searchBookList(bookContext);
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Long save(@RequestBody Context bookContext) {
			
		return bookService.save(bookContext);
	}
		
	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public Long update(@RequestBody Context bookContext) {
		
		return bookService.update(bookContext);
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public Long delete(@PathVariable("id") Long id) {
		
		return bookService.delete(id);
	
	}

}