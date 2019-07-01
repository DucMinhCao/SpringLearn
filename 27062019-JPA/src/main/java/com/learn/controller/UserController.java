package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.User;
import com.learn.repository.UserRepository;

@RestController
@RequestMapping("/example")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setName(name);
		userRepository.save(newUser);
		return "saved";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody List<User> getAllUser() {
		return userRepository.findAll();
	}
}
