package com.example.RegisterLogin.response;

public class LoginResponse {
	private String message;
	private boolean status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoginResponse [message=" + message + ", status=" + status + "]";
	}
	public LoginResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
