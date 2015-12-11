package com.vaibhav.egen.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.egen.dao.BookDao;
import com.vaibhav.egen.model.Book;
import com.vaibhav.egen.services.BookServices;

public class BookServiceImpl implements BookServices {

	@Autowired
	BookDao bookDao;
	@Transactional
	@Override
	public boolean addBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}
	@Transactional
	@Override
	public Book getBookById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}
	@Transactional
	@Override
	public Book getBookByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return bookDao.getBookByName(name);
	}
	@Transactional
	@Override
	public List<Book> listBooks() throws Exception {
		// TODO Auto-generated method stub
		return bookDao.listBooks();
	}
	@Transactional
	@Override
	public boolean updateBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		return bookDao.updateBook(book);
	}

}
