package com.rakib0hasan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakib0hasan.model.Course;
import com.rakib0hasan.resource.CourseResource;

@WebServlet("/addNewCourse")
public class AddNewCourse extends HttpServlet {
	
	private final CourseResource courseResource = new CourseResource();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseTitle = request.getParameter("courseTitle");
		String courseDescription = request.getParameter("courseDescription");
		
		Course course = new Course();
		course.setCourseTitle(courseTitle);
		course.setCourseDescription(courseDescription);
		
		try{
			courseResource.createCourse(course);
			request.setAttribute("alert", "Student added successfully!");
			request.getRequestDispatcher("course.jsp").forward(request, response);
		} catch(Exception e) {
			request.setAttribute("alert", "Something went wrong, please try again!");
			e.printStackTrace();
			request.getRequestDispatcher("course.jsp").forward(request, response);
		}
	}
}
