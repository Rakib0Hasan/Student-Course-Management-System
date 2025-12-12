<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="addStudent">
	<form action="addNewStudent" target="_self" method="post" autocomplete="off">
		<h3>Add new student</h3>
		<label for="fname">Enter first name:</label><br>
		<input type="text" id="fname" name="fname" placeholder="Rakib" required><br>
		<label for="lname">Enter last name:</label><br>
		<input type="text" id="lname" name="lname" placeholder="Hasan" required><br>
		<label for="email">Enter email:</label><br>
		<input type="email" id="email" name="email" placeholder="hasankhanrakib0@gmail.com" required><br>
		<label for="password">Enter password:</label><br>
		<input type="password" id="password" name="password" placeholder="123456" required><br>
		<label for="confirmPassword">Confirm password:</label><br>
		<input type="password" id="confirmPassword" name="confirmPassword" placeholder="123456" required><br>
		<label for="dateOfBirth">Date of Birth:</label>
		<input type="date" id="dateOfBirth" name="dateOfBirth" required>
		<label for="gender">Gender:</label><br>
			<select id="gender" name="gender" required>
				<option value="male">Male</option>
				<option value="female">Female</option>
				<option value="other">Other</option>
			</select><br>
			
		<label for="phone">Enter phone number:</label><br>
		<input type="tel" id="phone" name="phone" placeholder="+8801XXXXXXXXX"><br>
		<label for="address">Enter address:</label>
		<input type="text" id="address" name="address" required>
		<label for="department">Department:</label><br>
			<select id="department" name="department" required>
				<option value="Computer Science">Computer Science</option>
				<option value="Physics">Physics</option>
				<option value="Electrical Engineering">Electrical Engineering</option>
				<option value="other">Other</option>
			</select><br>
		
		<label for="cgpa">CGPA:</label>
		<input type="number" id="cgpa" name="cgpa" min="0" max="4" step="0.01"><br>
		
		<input type="submit" value="Submit">
		<c:if test="${not empty alert}">
			<div class="alertContainer">
				${alert}
			</div>
		</c:if>
	</form>
</div>
