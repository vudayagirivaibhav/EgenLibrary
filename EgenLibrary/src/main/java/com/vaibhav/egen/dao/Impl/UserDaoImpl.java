package com.vaibhav.egen.dao.Impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vaibhav.egen.dao.UserDao;
import com.vaibhav.egen.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@SuppressWarnings("unused")
	@Override
	public boolean addUser(User user) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		System.out.println(user.toString());

		String sql = "select * FROM user WHERE first_name = :first";
		SQLQuery query = session.createSQLQuery(sql);
		
		System.out.println(" user FName: " + user.getFirstName());
		String first = user.getFirstName();
		System.out.println(first+" first ");
		query.setParameter("first", user.getFirstName());
		List<User> results = query.list();
		System.out.println("From DB" + results.toString() + "size :"+results.size());
			if (results.isEmpty()) {
			session.save(user);
			tx.commit();
			session.close();

		} else {

			System.out.println("Already in the DB");
		}

		return false;
	}

	@Override
	public User getUserById(Long id) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		User user = (User) session.load(User.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return user;
	}

	@Override
	public User getUserByName(String firstName) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		User user = (User) session.get(User.class, firstName);
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("entered2");

		session = sessionFactory.openSession();
		System.out.println("entered3");
		List<User> userList = session.createCriteria(User.class).list();
		System.out.println("entered4");
		tx = session.beginTransaction();
		System.out.println("entered5");
		tx.commit();
		session.close();

		return userList;
	}
	@Transactional
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		System.out.println(user.toString());
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		System.out.println(user.toString());
		tx.commit();
		Serializable id = session.getIdentifier(user);
		session.close();
		return false;
	}
}
