package com.rakib0hasan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakib0hasan.model.Student;
import com.rakib0hasan.model.User;
import com.rakib0hasan.model.UserRole;
import com.rakib0hasan.resource.StudentResource;
import com.rakib0hasan.resource.UserResource;

@WebServlet("/addNewStudent")
public class AddNewStudent extends HttpServlet {
	
	private final StudentResource studentResource = new StudentResource();
	private final UserResource userResource = new UserResource();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String department = request.getParameter("department");
		String register = request.getParameter("register");
		double cgpa = 0.0;
		try {
			cgpa = Double.parseDouble(request.getParameter("cgpa"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(firstName == null || lastName == null || firstName.isBlank() || lastName.isBlank()) {
			request.setAttribute("alert", "Invalid name input!");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/student.jsp");
			rd.forward(request, response);
			return;
		}
		
		if(!password.equals(confirmPassword)) {
			request.setAttribute("alert", "Passwords do not match!");
			request.getRequestDispatcher("/WEB-INF/jsp/student.jsp").forward(request, response);
			return;
		}
		
		if(userResource.isEmailExists(email)) {
			request.setAttribute("alert", "Email already exists!");
			request.getRequestDispatcher("/WEB-INF/jsp/student.jsp").forward(request, response);
			return;
		}
		
		String fullName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase()
				+" "+lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
		
		User user = new User();
		user.setName(fullName);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(UserRole.STUDENT);
		
		Student student = new Student();
		student.setUser(user);
		student.setDateOfBirth(dateOfBirth);
		student.setGender(gender);
		student.setPhone(phone);
		student.setAddress(address);
		student.setDepartment(department);
		student.setCgpa(cgpa);
		
		try {
			userResource.createUser(user);
			studentResource.createStudent(student);
			request.setAttribute("alert", "Student added successfully!");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("alert", "Something went wrong, please try again!");
		}
		if(register.equals("register")) {
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/jsp/student.jsp").forward(request, response);
		}
	}
}
