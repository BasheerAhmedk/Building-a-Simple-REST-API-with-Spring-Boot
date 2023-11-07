package com.basheer.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping(path = "/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User retriveUser(@PathVariable int id){
		return service.findOne(id);
	}
	
}
