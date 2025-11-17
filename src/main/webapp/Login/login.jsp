<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
	<title>Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<body>
	<header>
		<c:import url="/header.jsp" />
	</header>
	
	<main>
		<aside class="left-sidebar">
			<p>This is left sidebar.</p>
		</aside>
		
		<section class="main-content">
			<div class="login">
				<form action="${pageContext.request.contextPath}LoginServlet" method="post" target="_self">
					<h2>Login</h2>
					<label for="username">Email:</label><br>
					<input type="email" id="email" name="email" placeholder="your@gmail.com" required><br>
					<label for="password">Password:</label><br>
					<input type="password" id="password" name="password" placeholder="Enter password" required><br>
					<input type="submit" value="Login">
				</form>
				<h5>If you are new please <a href="${pageContext.request.contextPath}/addStudent.jsp">register</a> as student.</h5>
			</div>
			
		</section>
		
		<aside class="right-sidebar">
			<p>This is right sidebar</p>
		</aside>
	</main>
	
	<footer>
		<c:import url="/footer.jsp" />
	</footer>
</body>
</html>