package com.vaibhav.egen.dao;

import java.util.List;

import com.vaibhav.egen.model.Author;

public interface AuthorDao {
	public boolean addAuthor(Author author);

	public Author getAuthorById(Long authorId);

	public Author getAuthorByName(String firstName);

	public List<Author> listAuthors();

	public boolean updateAuthor(Author author);

}
