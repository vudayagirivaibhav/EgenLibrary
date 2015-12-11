package com.vaibhav.egen.dao;

import java.util.List;

import com.vaibhav.egen.model.Book;

public interface BookDao {

	public boolean addBook(Book book);

	public Book getBookById(Long bookId);

	public Book getBookByName(String name);

	public List<Book> listBooks();

	public boolean updateBook(Book book);

	public String checkOut(Long book_id, Long user_id);

	

}
