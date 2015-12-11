package com.vaibhav.egen.services;

import java.util.List;

import com.vaibhav.egen.model.Book;

public interface BookServices {

	public boolean addBook(Book book) throws Exception;

	public Book getBookById(Long id) throws Exception;

	public Book getBookByName(String name) throws Exception;

	public List<Book> listBooks() throws Exception;

	public boolean updateBook(Book book) throws Exception;

	public String checkOut(Long book_id,Long user_id) throws Exception;
}
