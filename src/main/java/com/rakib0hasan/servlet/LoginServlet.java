package com.rakib0hasan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakib0hasan.dto.LoginRequest;
import com.rakib0hasan.model.User;
import com.rakib0hasan.resource.UserResource;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private final UserResource userResource = new UserResource();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginRequest loginRequest = new LoginRequest(email, password);
		
		User user = userResource.login(loginRequest);
		
		if(user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("error", "Invalid email or password");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
