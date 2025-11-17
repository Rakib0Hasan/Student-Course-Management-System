package com.rakib0hasan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseCode;
	
	@Column(name="courseTitle", nullable=false, length=100)
	private String courseTitle;
	
	@Column(name="courseDescription", nullable=true)
	private String courseDescription;
	
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseTitle + "]";
	}
}
