package com.example.Employee.Management.Rest.Api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Integer id2) {
		// TODO Auto-generated method stub
		
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmail(Object email2) {
		// TODO Auto-generated method stub
		
	}

	public Object getFirstname() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFirstname(Object firstname2) {
		// TODO Auto-generated method stub
		
	}

	public Object getLastname() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLastname(Object lastname2) {
		// TODO Auto-generated method stub
		
	}
}
