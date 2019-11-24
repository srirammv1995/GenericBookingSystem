package com.gym.app.Response;

public class UserResponse {

	private String username;
	private String operation;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String ReturnUserResponse()
	{
		return operation+" Operation Successfully performed on userName"+username;
	}
}
