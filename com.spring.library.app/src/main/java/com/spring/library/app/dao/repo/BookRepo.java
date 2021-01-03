package com.spring.library.app.dao.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.library.app.dao.entity.Book;



public interface BookRepo extends CrudRepository<Book, Long>{
	
	@Query(value = "SELECT b FROM Book b WHERE b.id = :id")
	public Book findWithid(@Param("id") Long id);
	
	@Query(value = "SELECT MAX(b.id) FROM Book b")
	public Long findMaxid();
	
	@Query(value = "SELECT b FROM Book b")
	public List<Book> getAllBookList();
	
	@Query(value = "SELECT * FROM Book b WHERE b.bookName like '%bookName%'", nativeQuery = true)
	public List<Book> searchBookList(@Param("BookName") String bookName);

}