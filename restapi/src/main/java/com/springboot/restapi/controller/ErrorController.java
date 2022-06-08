package com.springboot.restapi.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.restapi.model.CustomError;
import com.springboot.restapi.model.HexawarePerson;
import com.springboot.restapi.model.HexawareStatus;

@RestController
@RequestMapping("/")
public class ErrorController {
	
	@RequestMapping(value = "/error")
	public CustomError handleErrror(HttpServletRequest request) {
		Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		String description = "";
		
		if (statusCode != null) {
			if ((Integer)statusCode == HttpStatus.NOT_FOUND.value()) {
				description = "Resource not found!";
			} else if((Integer)statusCode == HttpStatus.UNAUTHORIZED.value()) {
				description = "You are not Authorized!";
			}
		}
		CustomError customError = new CustomError((Integer)statusCode, description, exception);
		
		return customError;
	}
	
	public String getErrorPath() {
		return "/error";
	}
	
	@GetMapping("/person")
	public HexawareStatus status(@RequestBody HexawarePerson person) {
		List<String> messages = new ArrayList<>();
		String[] errors;
		boolean validJSON = true;
		HexawareStatus status = new HexawareStatus();
		
		if (person.getName().length() <= 3) {
			validJSON = false;
			messages.add("Name should be at least 4 characters");
		}
		if (!person.getEmail().contains("@") || !person.getEmail().endsWith(".com")) {
			validJSON = false;
			messages.add("Please enter valid email");
		}
		if (person.getSalary() <= 1000) {
			validJSON = false;
			messages.add("Salary should be more than 1000");
		}
		
		if(validJSON) {
			status.setStatus("VALID");
			status.setErrors(new String[1]);
		} else {
			status.setStatus("ERROR");
			errors = new String[messages.size()];
			
			for (int i = 0; i < errors.length; i++) {
				errors[i] = messages.get(i);
			}
			status.setErrors(errors);
		}
		return status;
	}
}