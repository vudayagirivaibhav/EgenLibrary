package com.vaibhav.egen.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaibhav.egen.model.Author;
import com.vaibhav.egen.model.Status;
import com.vaibhav.egen.services.AuthorServices;

@Controller
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorServices authorServices;

	static final Logger logger = Logger.getLogger(AuthorController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addauthor(@RequestBody Author author) {
		try {
			authorServices.addAuthor(author);
			return new Status(1, "author added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{author_id}", method = RequestMethod.GET)
	public @ResponseBody Author getauthorById(@PathVariable("author_id") Long author_id) {
		System.out.println("GetAuthor()");
		Author author = new Author();
		try {
			author = authorServices.getAuthorById(author_id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return author;
	}

	@RequestMapping(value = "/authorlist", method = RequestMethod.GET)
	public @ResponseBody List<Author> getauthorList() {

		List<Author> authorList = null;
		try {
			System.out.println("entered");
			authorList = authorServices.listAuthors();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return authorList;
	}

	@RequestMapping(value = "/update/{author_id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody

	Status updateauthor(@PathVariable Long author_id, @RequestBody Author author) {
		try {
			author.setAuthorId(author_id);
			authorServices.updateAuthor(author);
			return new Status(1, "author updated Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

}
