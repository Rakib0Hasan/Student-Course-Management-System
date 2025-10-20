package com.rakib0hasan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakib0hasan.model.Student;
import com.rakib0hasan.resource.StudentResource;

@WebServlet("/addNewStudent")
public class AddNewStudent extends HttpServlet {
	
	private final StudentResource studentResource = new StudentResource();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		if(firstName == null || lastName == null || firstName.isBlank() || lastName.isBlank()) {
			request.setAttribute("alert", "Invalid name input!");
			RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
			rd.forward(request, response);
			return;
		}
		
		if(!password.equals(confirmPassword)) {
			request.setAttribute("alert", "Passwords do not match!");
			request.getRequestDispatcher("student.jsp").forward(request, response);
			return;
		}
		
		if(studentResource.isEmailExists(email)) {
			request.setAttribute("alert", "Email already exists!");
			request.getRequestDispatcher("student.jsp").forward(request, response);
			return;
		}
		
		String fullName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase()
				+" "+lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
		
		Student student = new Student();
		student.setName(fullName);
		student.setEmail(email);
		student.setPassword(password);
		
		try {
			studentResource.createStudent(student);
			request.setAttribute("alert", "Student added successfully!");
			request.getRequestDispatcher("student.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("alert", "Something went wrong, please try again!");
			request.getRequestDispatcher("student.jsp").forward(request, response);
		}
		
	}
}
