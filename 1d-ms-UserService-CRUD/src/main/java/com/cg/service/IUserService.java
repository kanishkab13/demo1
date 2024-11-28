package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.User;

public interface IUserService {
   public List<User> findAll();
   public Optional<User> findUserById(int id);
   public User createUser(User u);
   public String deleteUserById(int id);
   public User updateUser(User u);
}
