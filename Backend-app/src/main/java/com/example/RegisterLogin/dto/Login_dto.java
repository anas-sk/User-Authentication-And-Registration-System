package com.example.RegisterLogin.dto;

public class Login_dto {
	private String email;
	private String password;
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
	public Login_dto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Login_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login_dto [email=" + email + ", password=" + password + "]";
	}
	
}
