package com.spring.library.com.spring.library.app;
import java.util.Date;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.library.app.context.Context;
import com.spring.library.app.dao.entity.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({ "classpath:application.properties" })
public class ControllerIT {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	
	@LocalServerPort
	private int tomcatPortNo;
	
	
	
	@Test
	@Order(1)
	public void testRestTemplate() {
		
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com", String.class);
		
		System.out.println(tomcatPortNo);
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(response.getBody().length() > 0);
	}
	
	@Test
	@Order(2)
	public void findBookById() {
		
		String url = prepareBookRestServiceRootUrl() + "employee/1";
		
		ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
		
		Book books = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(1 == books.getId());
	}
	
	@Test
	@Order(3)
	public void saveBook() {
		
		String url = prepareBookRestServiceRootUrl() + "book";
		
		Context bookContext = new Context();
		//bookContext.setBookName("");;
		//bookContext.setAuthorName("");;
		//bookContext.setDescription("");
		
		ResponseEntity<Long> response = restTemplate.postForEntity(url, bookContext, Long.class);
		
		Long id = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertNotNull(id);
	}
	
   private String prepareBookRestServiceRootUrl() {
		
		return "http://localhost:" + tomcatPortNo + "/library/";
	}

}