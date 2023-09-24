package com.example.RegisterLogin.dto;

import javax.persistence.Column;

public class Employee_dto {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee_dto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	public Employee_dto(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Employee_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
