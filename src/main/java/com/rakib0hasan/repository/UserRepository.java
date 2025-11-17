package com.rakib0hasan.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rakib0hasan.model.User;
import com.rakib0hasan.util.HibernateUtil;

public class UserRepository {
	
	public User login(String email, String password) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from User u where u.email = :email and u.password = :password", User.class)
					.setParameter("email", email).setParameter("password", password).uniqueResult();
		}
	}

	public void saveUser(User user) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
