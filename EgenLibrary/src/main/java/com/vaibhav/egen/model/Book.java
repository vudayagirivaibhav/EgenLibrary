package com.vaibhav.egen.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "book")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Book implements Serializable {
	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Long bookid;

	@Column(name = "name")
	private String name;

	@ManyToOne
    @JoinColumn(name="author_id")
	private Author author;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	 
	private User user;
 
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public  Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString(){
		return "{name : " + this.getName() + " Author" + this.getAuthor().toString()+ "}";
	}
}
/*
 * 
 * o id
 * 
 * o name
 * 
 * o authors (can have multiple authors)
 * 
 * o checkedOutBy (user that has this book checked out)
 */
