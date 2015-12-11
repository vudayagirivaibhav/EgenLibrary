package com.vaibhav.egen.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vaibhav.egen.model.Author;
import com.vaibhav.egen.model.Book;
import com.vaibhav.egen.model.Status;
import com.vaibhav.egen.model.User;
import com.vaibhav.egen.services.AuthorServices;
import com.vaibhav.egen.services.BookServices;
import com.vaibhav.egen.services.UserServices;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookServices bookServices;
	@Autowired
	AuthorServices authorServices;

	@Autowired
	UserServices userServices;
	static final Logger logger = Logger.getLogger(BookController.class);

	/*
	 * @RequestMapping(method = RequestMethod.POST, value =
	 * "/checkout/{book_id}/{user_id}") public @ResponseBody Status
	 * addbook(@PathVariable Long book_id, @PathVariable Long user_id) throws
	 * Exception { System.out.println("addBook()"); Book newbook = (Book)
	 * bookServices.getBookById(book_id);
	 * System.out.println(newbook.toString());
	 * 
	 * return null; }
	 */
	/*
	 * @RequestMapping(value = "/create", method = RequestMethod.POST, consumes
	 * = MediaType.APPLICATION_JSON_VALUE) public @ResponseBody Status
	 * addbook(@RequestBody String jsonString) throws Exception {
	 * 
	 * System.out.println("Json method" + jsonString.toString()); JSONParser
	 * parser = new JSONParser(); Object obj = parser.parse(jsonString);
	 * JSONObject jsonObj = (JSONObject) obj;
	 * 
	 * String authorName = (String) jsonObj.get("authorName");
	 * System.out.println("authorName" + authorName); String bookName = (String)
	 * jsonObj.get("bookName"); System.out.println("bookName" + bookName); //
	 * Author Obj ; Author author = new Author(); author.setName(authorName);
	 * authorServices.addAuthor(author); Book book = new Book();
	 * book.setAuthor(author); book.setName(bookName); //book.setUser(user);
	 * bookServices.addBook(book); return null;
	 * 
	 * }
	 */
	@RequestMapping(value = "/createbook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status createBook(@RequestBody Book book) {
		try {
			 bookServices.addBook(book);
			return new Status(1, "Book added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Book getbookById(@PathVariable("id") long id) {
		Book book = null;
		try {
			book = bookServices.getBookById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public @ResponseBody Book getbookByName(@PathVariable("name") String name) {
		Book book = null;
		try {
			book = bookServices.getBookByName(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public @ResponseBody List<Book> getbookList() {

		List<Book> bookList = null;
		try {
			System.out.println("entered");
			bookList = bookServices.listBooks();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	@RequestMapping(value = "/update/{book_id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status updatebook(@PathVariable Long book_id, @RequestBody Book book) {
		try {
			book.setBookid(book_id);
			bookServices.addBook(book);
			return new Status(1, "book updated Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/checkout/{book_id}/{user_id}")
	public @ResponseBody Status checkOutBook(@PathVariable Long book_id, @PathVariable Long user_id,Book book)
			throws Exception {
		
	try{
		
		String msg = bookServices.checkOut(book_id, user_id);
		return new Status(1, msg);
		
	}
	catch(Exception e){
		
		return new Status(0,e.toString());
	}
		
		
				
		
}

}
