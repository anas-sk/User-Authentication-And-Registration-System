package com.example.RegisterLogin.Service;

import org.springframework.http.ResponseEntity;

import com.example.RegisterLogin.dto.Employee_dto;
import com.example.RegisterLogin.dto.Login_dto;
import com.example.RegisterLogin.response.LoginResponse;
import com.example.RegisterLogin.response.RegistrationResponse;

public interface Employee_Service {

	RegistrationResponse addEmployee(Employee_dto emp_dto);
	LoginResponse loginEmployee(Login_dto loginDto);

}
