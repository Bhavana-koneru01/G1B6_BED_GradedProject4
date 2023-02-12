package com.example.Employee.Management.Rest.Api.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Employee.Management.Rest.Api.model.User;
import com.example.Employee.Management.Rest.Api.repository.UserRepository;

public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		return new MyUserDetails(user);
	}
}
