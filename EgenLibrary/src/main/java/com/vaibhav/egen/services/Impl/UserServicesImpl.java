package com.vaibhav.egen.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaibhav.egen.dao.UserDao;
import com.vaibhav.egen.model.User;
import com.vaibhav.egen.services.UserServices;

public class UserServicesImpl implements UserServices {
	@Autowired
	UserDao userDao;
	@Transactional
	@Override
	public boolean addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}
	@Transactional
	@Override
	public User getUserById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}
	@Transactional
	@Override
	public User getUserByName(String firstName) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserByName(firstName);
	}
	@Transactional
	@Override
	public List<User> listUsers() throws Exception {
		// TODO Auto-generated method stub
		return userDao.listUsers();
	}
	@Transactional
	@Override
	public boolean updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);

	}
}
