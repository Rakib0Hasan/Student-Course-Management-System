package com.rakib0hasan.resource;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.rakib0hasan.model.Student;
import com.rakib0hasan.repository.StudentRepository;

public class StudentResource {
	
	private final StudentRepository repository = new StudentRepository();
	
	@GET
	public List<Student> getStudent(){
		return repository.getAllStudents();
	}
	
	@GET
	@Path("/{id}")
	public Response	 getStudentById(@PathParam("id") int id) {
		Student student = repository.getStudentById(id);
		if(student == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		else {
			return Response.ok(student).build();
		}
	}
	
	@GET
	public boolean isEmailExists(String email) {
		return repository.isEmailExists(email);
	}
	
	@POST
	public Response createStudent(Student student) {
		repository.saveStudent(student);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updateStudent(@PathParam("id")int id, Student student) {
		student.setId(id);
		repository.updateStudent(student);
		return Response.ok(student).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteStudent(@PathParam("id") int id) {
		repository.deleteStudent(id);
		return Response.noContent().build();
	}
}