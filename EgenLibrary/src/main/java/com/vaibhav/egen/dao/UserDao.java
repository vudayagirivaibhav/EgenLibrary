package com.vaibhav.egen.dao;

import java.util.List;

import com.vaibhav.egen.model.User;

public interface UserDao {

	public boolean addUser(User user) throws Exception;

	public User getUserById(Long userId) throws Exception;

	public User getUserByName(String firstName) throws Exception;

	public List<User> listUsers() throws Exception;

	public boolean updateUser(User user);

}
