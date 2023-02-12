package com.example.Employee.Management.Rest.Api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Management.Rest.Api.model.Role;
import com.example.Employee.Management.Rest.Api.service.RoleService;


@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@PostMapping("/roles")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}
}
