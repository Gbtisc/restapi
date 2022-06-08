package com.springboot.restapi.service;

import java.util.List;
import com.springboot.restapi.model.User;

public interface UserService {
	public User saveUser(User user);
	public List<User> getAllUsers();
	public List<User> getFilteredUsers(String UserName, String UserEmail);
	public User updateUser(User user, long userId);
	public void deleteUser(long userId);
}