package com.learn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.model.User;
import com.learn.repository.UserRepository;
import com.learn.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findById(id).orElse(new User());
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "{'delete':'done'}";
	}

}
