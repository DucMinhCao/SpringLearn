package com.learn.service;

import java.util.List;

import com.learn.model.User;

public interface UserService {
	List<User> userList();
	
	User findOne(Long id);
	
	void addUser(User user);
	
	String deleteUser(Long id);
}
