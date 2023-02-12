package com.example.Employee.Management.Rest.Api.sewrviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Management.Rest.Api.model.Role;
import com.example.Employee.Management.Rest.Api.repository.RoleRepository;
import com.example.Employee.Management.Rest.Api.service.RoleService;



@Service
public class RoleServiceImpl  implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	
	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

}
