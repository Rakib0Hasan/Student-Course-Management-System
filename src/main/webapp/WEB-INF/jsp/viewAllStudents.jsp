<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<div class="viewAllStudents">
	<a href="${pageContext.request.contextPath}/viewAllStudentsServlet" id="viewAllStudentsLink" onclick="studentsTable()">View all students</a>
</div>
<br>

<div id="allStudentsTable" class="viewAllStudentsTable" >
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Password</th>
			<th>Date of birth</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Department</th>
			<th>CGPA</th>
		</tr>
		<c:forEach var="student" items="${students}">
		<tr>
			<td>${student.studentId}</td>
			<td>${student.user.name}</td>
			<td>${student.user.email}</td>
			<td>${student.phone}</td>
			<td>${student.user.password}</td>
			<td>${student.dateOfBirth}</td>
			<td>${student.gender}</td>
			<td>${student.address}</td>
			<td>${student.department}</td>
			<td>${student.cgpa}</td>
		</tr>
		</c:forEach>
	</table>
</div>
