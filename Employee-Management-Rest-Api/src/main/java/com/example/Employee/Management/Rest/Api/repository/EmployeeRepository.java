package com.example.Employee.Management.Rest.Api.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.Management.Rest.Api.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstnameContainsAllIgnoreCase(String firstname);

}
