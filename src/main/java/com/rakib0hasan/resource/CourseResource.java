package com.rakib0hasan.resource;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import com.rakib0hasan.model.Course;
import com.rakib0hasan.repository.CourseRepository;

public class CourseResource {
	
	private final CourseRepository courseRepository = new CourseRepository();
	
	@POST
	public Response createCourse(Course course) {
		courseRepository.saveCourse(course);
		return Response.status(Response.Status.CREATED).build();
	}
}
