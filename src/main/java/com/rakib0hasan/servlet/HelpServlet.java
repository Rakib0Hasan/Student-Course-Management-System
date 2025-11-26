package com.rakib0hasan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/help")
public class HelpServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("activePage", request.getServletPath());
			request.getRequestDispatcher("/WEB-INF/jsp/help.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
