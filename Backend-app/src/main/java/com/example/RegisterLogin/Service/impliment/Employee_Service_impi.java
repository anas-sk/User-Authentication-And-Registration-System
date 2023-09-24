package com.example.RegisterLogin.Service.impliment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Repository.Employee_Repository;
import com.example.RegisterLogin.Service.Employee_Service;
import com.example.RegisterLogin.dto.Employee_dto;
import com.example.RegisterLogin.dto.Login_dto;
import com.example.RegisterLogin.response.LoginResponse;
import com.example.RegisterLogin.response.RegistrationResponse;



@Service
public class Employee_Service_impi implements Employee_Service {
	
	@Autowired
	private Employee_Repository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Override
	public RegistrationResponse addEmployee(Employee_dto emp_dto) {
		boolean isemailpresent = repository.existsByEmail(emp_dto.getEmail());
		if(!isemailpresent) {
			
		Employee emp = new Employee(
					emp_dto.getId(),
					emp_dto.getName(),
					emp_dto.getEmail(),
					this.passwordEncoder.encode(emp_dto.getPassword())
				);
		repository.save(emp);
		return new RegistrationResponse("Z",true);
		}
		else {
			return new RegistrationResponse("User already exists", false);
		}
	}


	@Override
	public LoginResponse loginEmployee(Login_dto loginDto) {
		String message = "";
		Employee emp1 = repository.findByEmail(loginDto.getEmail());
		if(emp1 != null) {
			String password = loginDto.getPassword();
			String encodedPassword = emp1.getPassword();
			boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight) {
				Optional<Employee> emp = repository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
				if(emp.isPresent()) {
					return new LoginResponse("Login Success", true);
				}
				else {
					return new LoginResponse("Login Failed", false);
				}
			}
			else {
				return new LoginResponse("password Not Match",false);
			}
		}
		else {
			return new LoginResponse("Email not Exists" , false);
		}
	}
	

}
