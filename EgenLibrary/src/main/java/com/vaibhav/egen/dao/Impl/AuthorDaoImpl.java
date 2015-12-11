package com.vaibhav.egen.dao.Impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vaibhav.egen.dao.AuthorDao;
import com.vaibhav.egen.model.Author;
import com.vaibhav.egen.model.User;

@Repository("authorDao")
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional
	@Override
	public boolean addAuthor(Author author) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		System.out.println(author.toString());

		String sql = "select * FROM Author WHERE author_id = :first";
		SQLQuery query = session.createSQLQuery(sql);

		System.out.println(" user FName: " + author.getName());
		String first = author.getName();
		System.out.println(first + "first");
		query.setParameter("first", author.getName());
		List<Author> results = query.list();
		System.out.println("From DB" + results.toString() + "size :" + results.size());
		if (results.isEmpty()) {
			session.save(author);
			tx.commit();
			session.close();

		} else {

			System.out.println("Already in the DB");
		}

		return false;
	}
	
	@Transactional
	@Override
	public Author getAuthorById(Long authorId) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Author author = (Author) session.load(Author.class, new Long(authorId));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return author;
	}

	@Transactional
	@Override
	public Author getAuthorByName(String name) {
		session = sessionFactory.openSession();
		Author author = (Author) session.get(Author.class, name);
		tx = session.getTransaction();
		tx.commit();
		return author;
	}

	@Transactional
	@Override
	public List<Author> listAuthors() {
		// TODO Auto-generated method stub
		System.out.println("entered2");

		session = sessionFactory.openSession();
		System.out.println("entered3");
		@SuppressWarnings("unchecked")
		List<Author> authorList = session.createCriteria(Author.class).list();
		System.out.println("entered4");
		tx = session.beginTransaction();
		System.out.println("entered5");
		tx.commit();
		session.close();
		System.out.println("Author Size:" + authorList.size()); 
	
		return authorList;
	}

	@Transactional
	@Override
	public boolean updateAuthor(Author author) {
		Session session = sessionFactory.openSession();
		System.out.println(author.toString());
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(author);
		System.out.println(author.toString());
		tx.commit();
		Serializable id = session.getIdentifier(author);
		session.close();
		return false;
	}

}
