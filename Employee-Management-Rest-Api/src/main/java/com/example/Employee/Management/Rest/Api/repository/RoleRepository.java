package com.example.Employee.Management.Rest.Api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.Management.Rest.Api.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>  {

}
