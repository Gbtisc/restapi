package com.springboot.restapi.controller;

import java.util.List;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.restapi.model.User;
import com.springboot.restapi.service.UserService;

@RestController //@RestController = @Controller + @ResponseBody
@RequestMapping("/users")
public class UsersController implements ErrorController {
	
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	private UserService userService;
	
	@GetMapping("/index")//localhost:8080/
	public String index() {
		return "Welcome!";
	}
	
	@PostMapping("/newUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		user.toString();
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/userList")//JSON = @GetMapping("/list") or XML = @GetMapping(value = "/list", produces = MediaType.APPLICATION_XML_VALUE)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/userList/{userName}/{userEmail}")
	public List<User> filterUsers(@PathVariable("userName") String userName, @PathVariable("userEmail") String userEmail) throws Exception {
			//@PathVariable Bind the request URL template path variable to the method variable
		return userService.getFilteredUsers(userName, userEmail);
	}
	
	@PutMapping("/userUpdate")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		user.toString();
		return new ResponseEntity<User>(userService.updateUser(user, user.getUserId()), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/userDown/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
	}
}
