package com.rakib0hasan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rakib0hasan.dto.LoginRequest;
import com.rakib0hasan.model.User;
import com.rakib0hasan.resource.UserResource;

@WebServlet("/LoginValidationServlet")
public class LoginValidationServlet extends HttpServlet {
	
	private final UserResource userResource = new UserResource();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginRequest loginRequest = new LoginRequest(email, password);
		User user = userResource.login(loginRequest);
		
		if(user != null) {
			HttpSession existingSession = request.getSession(false);
			String redirectUrl = null;
			
			if(existingSession != null) {
				redirectUrl = (String) existingSession.getAttribute("redirectAfterLogin");
				existingSession.invalidate();
			}
			
			HttpSession newSession = request.getSession();
			newSession.setAttribute("user", user);
			
			if(redirectUrl != null) {
				response.sendRedirect(redirectUrl);
			} else {
				response.sendRedirect(request.getContextPath() + "/profile");
			}

		} else {
			request.setAttribute("error", "Invalid email or password");
	        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}
}

