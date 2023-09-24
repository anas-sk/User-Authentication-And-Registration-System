package com.example.RegisterLogin.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.RegisterLogin.Service.Employee_Service;
import com.example.RegisterLogin.dto.Employee_dto;
import com.example.RegisterLogin.dto.Login_dto;
import com.example.RegisterLogin.response.LoginResponse;
import com.example.RegisterLogin.response.RegistrationResponse;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private Employee_Service service;
	
	@PostMapping("/save")
	public ResponseEntity<RegistrationResponse> saveEmployee(@RequestBody Employee_dto emp_dto) {
		return new ResponseEntity<RegistrationResponse>(service.addEmployee(emp_dto),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginEmployee(@RequestBody Login_dto login_dto) {
		LoginResponse loginresponse = service.loginEmployee(login_dto);
		return new ResponseEntity<LoginResponse>(loginresponse,HttpStatus.OK);
	}
}
