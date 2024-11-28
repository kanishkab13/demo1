package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.User;
import com.cg.repository.UserRepository;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userrepo;
	@Override
	public List<User> findAll() {
		return userrepo.findAll();
	}
	
	public Optional<User> findUserById(int id){
		return userrepo.findById(id);
	}
	
	public User createUser(User u) {
		return userrepo.save(u);
	}
	
	public String deleteUserById(int id) {
		if (userrepo.existsById(id)) {
	        userrepo.deleteById(id);;
	         return "deleted";
	    } else {
	    	 return "id not found";
	    }
	}
	
	public User updateUser(User u) {
		return userrepo.save(u);
	}

}
