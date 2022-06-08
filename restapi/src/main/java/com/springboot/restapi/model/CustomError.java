package com.springboot.restapi.model;

public class CustomError {
	private final String error = "ERROR";
	private int statusCode;
	private String description;
	private Exception exception;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public String getError() {
		return error;
	}
	
	public CustomError(int statusCode, String description, Exception exception) {
		super();
		this.statusCode = statusCode;
		this.description = description;
		this.exception = exception;
	}
}