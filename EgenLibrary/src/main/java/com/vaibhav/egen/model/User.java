package com.vaibhav.egen.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middlename;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone")
	private BigInteger phone;

	@Column(name = "zip")
	private String zip;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return "{name : " + this.getFirstName() + " " + this.getLastname() + ", middlename : " + this.getMiddlename()
				+ ", Age : " + this.getAge() + ", " + this.getZip() + "}";
	}

	/*
	 * 
	 * o id
	 * 
	 * o firstName (alphabets)
	 * 
	 * o middleName (alphabets but it is optional)
	 * 
	 * o lastName (alphabets)
	 * 
	 * o age (valid non zero positive number)
	 * 
	 * o gender (M or F)
	 * 
	 * o phone (10-digit positive number)
	 * 
	 * o zip (optional field)
	 */
}
