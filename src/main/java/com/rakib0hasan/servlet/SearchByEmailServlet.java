package com.rakib0hasan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import com.rakib0hasan.model.Student;
import com.rakib0hasan.resource.StudentResource;

@WebServlet("/SearchByEmailServlet")
public class SearchByEmailServlet extends HttpServlet {
	
	private final StudentResource studentResource = new StudentResource();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		 Response res = studentResource.getStudentByEmail(email);
		 Student student = (Student) res.getEntity();
		 
		 request.setAttribute("student", student);
		 
		 request.getRequestDispatcher("student.jsp").forward(request, response);
	}
}
