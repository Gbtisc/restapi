package com.springboot.restapi.model;

public class HexawarePerson {
	private String name;
	private String email;
	private int salary;
	
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
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public HexawarePerson(String name, String email, int salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
}