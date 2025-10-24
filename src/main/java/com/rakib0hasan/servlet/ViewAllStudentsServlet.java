package com.rakib0hasan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakib0hasan.model.Student;
import com.rakib0hasan.resource.StudentResource;

@WebServlet("/ViewAllStudents")
public class ViewAllStudentsServlet extends HttpServlet {
	
	private final StudentResource studentResource = new StudentResource();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = studentResource.getStudent();
		request.setAttribute("students", students);
		request.getRequestDispatcher("student.jsp").forward(request, response);
	}
}
