package com.example.Employee.Management.Rest.Api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Management.Rest.Api.model.User;
import com.example.Employee.Management.Rest.Api.service.UserService;


@RestController
@RequestMapping("/api")
public class UserRegistrationController {
	@Autowired
	UserService userService;

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}