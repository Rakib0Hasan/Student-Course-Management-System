<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="addNewCourse">
	<h3>Add a new course:</h3>
	<form action="addNewCourse" target="_self" method="post" autocomplete="off">
		<label for="courseTitle">Course title:</label><br>
		<input type="text" id="courseTitle" name="courseTitle" placeholder="Course name" required><br>
		<label for="courseDescription">Course description:</label><br>
		<textarea id="courseDescription" name="courseDescription" placeholder="Course details" rows="4" cols="50" required></textarea>
		<input type="submit" value="Submit">
	</form>
</div>

