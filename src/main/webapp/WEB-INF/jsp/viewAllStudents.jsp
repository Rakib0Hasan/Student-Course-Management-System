<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<div class="viewAllStudents">
	<a id="viewAllStudentsLink" onclick="studentsTable()">View all students</a>
</div>
<br>

<div id="allStudentsTable" class="viewAllStudentsTable" >
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<c:forEach var="student" items="${students}">
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.email}</td>
			<td>${student.password}</td>
		</tr>
		</c:forEach>
	</table>
</div>


