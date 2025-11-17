package com.rakib0hasan.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.rakib0hasan.dto.LoginRequest;
import com.rakib0hasan.model.User;
import com.rakib0hasan.repository.UserRepository;

@Path("/users")
public class UserResource {
	
	private final UserRepository userRepository = new UserRepository();
	
	@POST
	@Path("/login")
	public User login(LoginRequest request) {
		return userRepository.login(request.getEmail(), request.getPassword());
		
	}
	
	@POST
	public Response createUser(User user) {
		userRepository.saveUser(user);
		return Response.status(Response.Status.CREATED).build();
	}
}
