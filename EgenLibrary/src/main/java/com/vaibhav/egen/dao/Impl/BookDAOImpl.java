package com.vaibhav.egen.dao.Impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.egen.dao.BookDao;
import com.vaibhav.egen.model.Book;

public class BookDAOImpl implements BookDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	     
		session.save(book);
		//tx.commit();
		session.close();
		return false;
	}

	@Override
	public Book getBookById(Long bookId) {
		session = sessionFactory.openSession();
		Book book = (Book) session.load(Book.class, new Long(bookId));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return book;
	}

	@Override
	public Book getBookByName(String name) {
		System.out.println("name" + name);
		session = sessionFactory.openSession();
		// TODO Auto-generated method stub

		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.eq("name", name));
		Book resBook = (Book) criteria.uniqueResult();
		System.out.println(resBook.getName() + resBook.getBookid()+ resBook.getAuthor() + resBook.getUser());
		session.close();
		return resBook;
	}

	@Override
	public List<Book> listBooks() {
		System.out.println("entered2");
		session = sessionFactory.openSession();
		System.out.println("entered3");
		@SuppressWarnings("unchecked")
		List<Book> bookList = session.createCriteria(Book.class).list();
		System.out.println("entered4");
		tx = session.beginTransaction();
		System.out.println("entered5");
		tx.commit();
		session.close();
		System.out.println("Book Size:" + bookList.size());
		return bookList;
	}

	@Override
	public boolean updateBook(Book book) {
		Session session = sessionFactory.openSession();
		System.out.println(book.toString());
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(book);
		System.out.println(book.toString());
		tx.commit();
		Serializable id = session.getIdentifier(book);
		session.close();
		return false;
	}
}
