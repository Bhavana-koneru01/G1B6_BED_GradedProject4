package com.example.Employee.Management.Rest.Api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Management.Rest.Api.model.Employee;
import com.example.Employee.Management.Rest.Api.service.EmployeeService;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create")
  
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		
		return  ResponseEntity.status(HttpStatus.CREATED).body((employeeService.createEmployee(employee)));
	}

	
	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees();
		return employees;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		return ResponseEntity.ok().body(employeeService.findEmployeeById(id).get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
		return ResponseEntity.ok().body(employeeService.updateEmployee (employee,id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee (id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
@GetMapping("/search/{firstname}")
public ResponseEntity<List<Employee>> getEmployeeFirstname(@PathVariable String firstname){
	List<Employee> emp = this.employeeService.findByFirstname(firstname);
	
	return ResponseEntity.ok().body(emp);
	
}

@GetMapping("/sort")
public ResponseEntity<List<Employee>>getAllEmployee(
		@RequestParam(value = "sortBy", defaultValue = "firstname",required = false) String sortBy,
@RequestParam(value = "sortDir", defaultValue = "dec",required = false) String sortDir)
{
	List<Employee>allEmp = this.employeeService.findAllEmployees(sortBy,sortDir);
	return new ResponseEntity<List<Employee>>(allEmp,HttpStatus.OK);
}
}
