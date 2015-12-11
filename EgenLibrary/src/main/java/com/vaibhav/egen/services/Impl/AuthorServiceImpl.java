package com.vaibhav.egen.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.egen.dao.AuthorDao;
import com.vaibhav.egen.model.Author;
import com.vaibhav.egen.services.AuthorServices;

public class AuthorServiceImpl implements AuthorServices {

	@Autowired
	AuthorDao authorDao;
	@Transactional
	@Override
	public boolean addAuthor(Author author) throws Exception {
		// TODO Auto-generated method stub
		return authorDao.addAuthor(author);
	}
	@Transactional
	@Override
	public Author getAuthorById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return authorDao.getAuthorById(id);
	}
	@Transactional
	@Override
	public Author getAuthorByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return authorDao.getAuthorByName(name);
	}
	@Transactional
	@Override
	public List<Author> listAuthors() throws Exception {
		// TODO Auto-generated method stub
		return authorDao.listAuthors();
	}
	@Transactional
	@Override
	public boolean updateAuthor(Author author) throws Exception {
		// TODO Auto-generated method stub
		return authorDao.updateAuthor(author);
	}

}
