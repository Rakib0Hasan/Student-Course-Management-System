package com.rakib0hasan.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rakib0hasan.model.Course;
import com.rakib0hasan.util.HibernateUtil;

public class CourseRepository {

	public void saveCourse(Course course) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(course);
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
}
