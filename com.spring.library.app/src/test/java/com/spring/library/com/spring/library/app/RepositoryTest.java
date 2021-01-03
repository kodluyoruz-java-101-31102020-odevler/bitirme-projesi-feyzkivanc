package com.spring.library.com.spring.library.app;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.library.app.dao.entity.Book;
import com.spring.library.app.dao.repo.BookRepo;

;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class RepositoryTest {

	@Autowired
	private BookRepo bookRepo;
	@Test
	@Order(1)
	public void selectBookByid() {
		
		Long maxId = bookRepo.findMaxid();
		Book book = bookRepo.findWithid(maxId);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getId() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	@Order(2)
	public void saveBook() {
		
		Long maxId = bookRepo.findMaxid();
		Long newid = maxId + 1;
		
		Book book = new Book();
		book.setId(newid);
		book.setBookName("");
		
		
		bookRepo.save(book);
		
		book = bookRepo.findWithid(newid);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getId() > 0);
	}
}
