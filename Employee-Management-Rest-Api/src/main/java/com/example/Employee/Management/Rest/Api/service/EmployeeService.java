package com.example.Employee.Management.Rest.Api.service;
import java.util.List;
import java.util.Optional;

import com.example.Employee.Management.Rest.Api.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee,int id);

	void deleteEmployee(int id);

	Optional<Employee> findEmployeeById(int id);

	

	List<Employee> findByFirstname(String firstname);

	List<Employee> findAllEmployees(String sortBy, String sortDir);

	List<Employee> findAllEmployees();
}
