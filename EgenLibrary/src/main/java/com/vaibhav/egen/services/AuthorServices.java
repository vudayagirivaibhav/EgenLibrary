package com.vaibhav.egen.services;

import java.util.List;

import com.vaibhav.egen.model.Author;

public interface AuthorServices {

	public boolean addAuthor(Author author) throws Exception;

	public Author getAuthorById(Long id) throws Exception;

	public Author getAuthorByName(String name) throws Exception;

	public List<Author> listAuthors() throws Exception;

	public boolean updateAuthor(Author author) throws Exception;
}
