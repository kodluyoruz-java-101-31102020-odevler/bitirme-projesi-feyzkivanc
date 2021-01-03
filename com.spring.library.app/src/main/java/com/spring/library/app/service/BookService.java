package com.spring.library.app.service;
import java.util.List;

import com.spring.library.app.context.Context;
import com.spring.library.app.dao.entity.Book;

public interface BookService {

	public Book findByid(Long id);
	public List<Book> getAllBookList();
	public Long save(Context bookContext);
	public Long update(Context bookContext);
	public Long delete(Long id);
	public List<Book> searchBookList(Context bookContext);

}
