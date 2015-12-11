package com.vaibhav.egen.services;

import java.util.List;

import com.vaibhav.egen.model.User;

public interface UserServices {

	public boolean addUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;

	public User getUserByName(String firstName) throws Exception;

	public List<User> listUsers() throws Exception;

	public boolean updateUser(User user) throws Exception;

}
