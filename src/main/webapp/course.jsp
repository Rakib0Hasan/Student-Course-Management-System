<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
<title>Course</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<header>
		<jsp:include page="header.jsp"/>
	</header>
	
	<main>
		<aside class="left-sidebar">
			<p>This is left sidebar.</p>
		</aside>
		
		<section class="main-content">
			<c:import url="addNewCourse.jsp" />
			<br>
			<c:import url="viewAllCourses.jsp" />
		</section>
		
		<aside class="right-sidebar">
			<p>This is right sidebar</p>
		</aside>
	</main>
	
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>
</body>
</html>