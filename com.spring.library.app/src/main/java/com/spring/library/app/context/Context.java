package com.spring.library.app.context;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Context {

	@Entity
	@Table(name = "books")
	public class Book {
		
		@Id
		@Column(name = "book_no")
		private long id;
		
		@Column(name = "book_name")
		private String BookName;
		
		@Column(name = "author_name")
		private String author;
		
		
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getBookName() {
			return BookName;
		}
		public void setBookName(String bookName) {
			this.BookName = bookName;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		
	}

	public String getBookName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
