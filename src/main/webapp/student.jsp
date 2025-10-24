<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
<title>Student</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script src="${pageContext.request.contextPath}/js/script.js"></script>
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
			<jsp:include page="addStudent.jsp" />
			<br>
			<jsp:include page="viewAllStudents.jsp" />
			<c:if test="${empty students}">
				<%
					request.getRequestDispatcher("ViewAllStudents").forward(request, response);
				%>
			</c:if>
			
			<c:import url="searchByEmail.jsp" />
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