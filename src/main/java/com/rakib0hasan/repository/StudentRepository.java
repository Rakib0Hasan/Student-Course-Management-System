package com.rakib0hasan.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rakib0hasan.model.Student;
import com.rakib0hasan.util.HibernateUtil;

public class StudentRepository {
	
	public List<Student> getAllStudents() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Student", Student.class).list();
		}
	}

	public Student getStudentById(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Student.class, id);
		}
	}
	
	
	public boolean isEmailExists(String email) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Long count = (Long) session.createQuery("Select count(s) from Student s where s.email = :email")
					.setParameter("email", email).uniqueResult();
			if(count > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
	
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}

	public void updateStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, id);
			if(student != null) {
				session.delete(student);
			}
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
