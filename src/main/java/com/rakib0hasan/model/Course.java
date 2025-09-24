package com.rakib0hasan.model;

public class Course {
	
	private int courseCode;
	private String courseName;
	
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + "]";
	}
}
