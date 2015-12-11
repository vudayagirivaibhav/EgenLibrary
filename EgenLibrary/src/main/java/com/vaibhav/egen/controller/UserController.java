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

import com.vaibhav.egen.model.Status;
import com.vaibhav.egen.model.User;
import com.vaibhav.egen.services.UserServices;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServices userServices;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addUser(@RequestBody User user) {
		try {
			userServices.addUser(user);
			return new Status(1, "User added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable("id") long id) {
		User user = null;
		try {
			user = userServices.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public @ResponseBody List<User> getUserList() {

		List<User> userList = null;
		try {
			System.out.println("entered");
			userList = userServices.listUsers();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	@RequestMapping(value = "/update/{user_id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody

	Status updateUser(@PathVariable Long user_id, @RequestBody User user) {
		try {
			user.setUserId(user_id);
			userServices.updateUser(user);
			return new Status(1, "user updated Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

}
