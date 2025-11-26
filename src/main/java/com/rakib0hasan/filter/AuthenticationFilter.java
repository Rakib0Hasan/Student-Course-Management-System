package com.rakib0hasan.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rakib0hasan.model.User;

@WebFilter(filterName="AuthenticationFilter", urlPatterns="/*")
public  class AuthenticationFilter implements Filter {
	
	private static final List<String> ALLOWED_URLS = Arrays.asList(
			"/css/", "/images/", "/js/", "/LoginValidationServlet","/home", "/login");
	
	private boolean isAllowed(String path) {
		return ALLOWED_URLS.stream().anyMatch(path::startsWith) ||
				path.equals("/") ||
				path.endsWith(".css") ||
				path.endsWith(".js") ||
				path.endsWith(".png") ||
				path.endsWith(".jpg") ||
				path.endsWith(".jpeg") ||
				path.endsWith(".gif") ||
				path.endsWith(".ico");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String requestURI = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
		String path = requestURI.substring(contextPath.length());
		
		if(isAllowed(path)) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = httpRequest.getSession(false);
		User user = null;
		
		if(session != null) {
			user = (User) session.getAttribute("user");
		}
		
		if(user == null) {
			if(session == null) {
				session = httpRequest.getSession();
			}
			session.setAttribute("redirectAfterLogin", requestURI);
			session.setAttribute("loginMessage", "Please login first to access this page.");
			
			httpResponse.sendRedirect(contextPath + "/login");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
