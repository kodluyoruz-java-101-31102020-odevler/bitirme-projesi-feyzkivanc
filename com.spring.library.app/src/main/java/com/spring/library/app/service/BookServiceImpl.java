package com.spring.library.app.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.library.app.dao.repo.BookRepo;
import com.spring.library.app.context.Context;
import com.spring.library.app.dao.entity.Book;

@Service
public abstract  class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	public Book findByid(Long id) {

		return bookRepo.findWithid(id);
	}

	public List<Book> getAllBookList() {

		return bookRepo.getAllBookList();
	}

	public List<Book> searchBookList(Context bookContext) {

		return bookRepo.searchBookList(bookContext.getBookName());

	}
    

	@Transactional
	public Long delete(Long id) {

		bookRepo.deleteById(id);
		return id;
	}

}