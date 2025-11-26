<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="searchByEmail">
	<form action="SearchByEmailServlet" target="_self" method="get">
		<label for="email">Search by email:</label><br>
		<input type="email" id="email" name="email" placeholder="hasankhanrakib0@gmail.com" required><br>
		<input type="submit" value="Search">
	</form>
</div>

<script type="text/javascript">
	let studentExists = ${not empty student};
	window.onload = function() {
		showTable();
	};
</script>

<div>
	<c:import url="searchByEmailStudentTable.jsp" />
</div>