package com.example.Employee.Management.Rest.Api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.Management.Rest.Api.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);


}
