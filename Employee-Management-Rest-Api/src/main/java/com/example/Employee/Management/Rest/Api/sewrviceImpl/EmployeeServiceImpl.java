package com.example.Employee.Management.Rest.Api.sewrviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Employee.Management.Rest.Api.model.Employee;
import com.example.Employee.Management.Rest.Api.repository.EmployeeRepository;
import com.example.Employee.Management.Rest.Api.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee( Employee employee ,int id) {
		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		Employee e = emp.get();
		e.setId(employee.getId());
		e.setEmail(employee.getEmail());
		e.setFirstname(employee.getFirstname());
		e.setLastname(employee.getLastname());

		
		return employeeRepository.save(e);
	}

	@Override
	public void deleteEmployee(int id) {

		
	this.	employeeRepository.deleteById(id);
		
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {

		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findByFirstname(String firstname) {

		return employeeRepository.findByFirstnameContainsAllIgnoreCase(firstname);
	}
	
	@Override
	public List<Employee> findAllEmployees(String sortBy,String sortDir){
		Sort sort = null;
		if(sortDir.trim().toLowerCase().equals("asc")) {
			sort = Sort.by(sortBy).ascending();
		}
		else {
			sort = Sort.by(sortBy).descending();
		}
		Pageable pageable = PageRequest.of(0, 10, sort);
		Page<Employee> allPages = this.employeeRepository.findAll(pageable);
	List<Employee> allEmployees = allPages.getContent();
		return allEmployees;
	}
}
