package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.exception.ResourceNotFoundException;
import com.cg.model.User;
import com.cg.service.IUserService;

import jakarta.validation.Valid;

@RequestMapping("/api")
@RestController
public class UserController {
	@Autowired
	IUserService userservice;
	
	@GetMapping("/user")
	public List<User> findAll(){
		return userservice.findAll();
	}
	
	
	@GetMapping("/user/{id}")
	public Optional<User> findUserById(@PathVariable int id){
		return userservice.findUserById(id);
	}
	
	@GetMapping("/prod/{id}")
	Optional<User>findByUserIdFromDBWithException(@PathVariable int id) throws ResourceNotFoundException
	{	Optional<User> user = userservice.findUserById(id);
	    //java8 lambda version
    	user.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
    	System.out.println(id);
        return user ;	
	}
	
	
	@PostMapping("/user")
	public User createUser1(@Valid @RequestBody User u) throws BadRequestException {
		if(u.getUsername() == " " || u.getPassword() == " " || u.getEmail() == " ")
			throw new BadRequestException("Invalid user details");
		return userservice.createUser(u);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUserById(@PathVariable int id) throws ResourceNotFoundException {
		String r= userservice.deleteUserById(id);
		if(r==null || r.isEmpty()) {
			throw new ResourceNotFoundException("User not found with this id"+id);
		}
		return r;
	}
	
	@PutMapping("/update")
	public User updateUser(@Valid @RequestBody User u) throws BadRequestException{
		if(u.getUsername() == " " || u.getPassword() == " " || u.getEmail() == " ")
			throw new BadRequestException("Invalid user details so cannot update user details");
		return userservice.updateUser(u);
	}

}
