<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="addStudent">
	<form action="addNewStudent" target="_self" method="post" autocomplete="off">
		<h3>Add new student</h3>
		<label for="fname">Enter first name:</label><br>
		<input type="text" id="fname" name="fname" placeholder="Rakib" required><br>
		<label for="lname">Enter last name:</label><br>
		<input type="text" id="lname" name="lname" placeholder="Hasan" required><br>
		<label for="email">Enter email:</label><br>
		<input type="email" id="email" name="email" placeholder="rakib@gmail.com" required><br>
		<label for="password">Enter password:</label><br>
		<input type="password" id="password" name="password" placeholder="123456" required><br>
		<label for="confirmPassword">Confirm password:</label><br>
		<input type="password" id="confirmPassword" name="confirmPassword" placeholder="123456" required><br>
		<input type="submit" value="Submit">
		<%
			String alert = (String)request.getAttribute("alert");
			if(alert != null){
		%>
		<div class="alertContainer">
			<%= alert %>
		</div>	
		<%
			}
		%>
	</form>
</div>