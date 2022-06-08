package com.springboot.restapi.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.springboot.restapi.exception.ResourceNotFoundException;
import com.springboot.restapi.model.User;
import com.springboot.restapi.repository.UserRepository;
import com.springboot.restapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getFilteredUsers(String UserName, String UserEmail) {
		return userRepository.searchByUserNameAndUserEmailLike(UserName, UserEmail);
	}

	@Override
	public User updateUser(User user, long userId) {
		User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setUserName(user.getUserName());
		existingUser.setUserPassword(user.getUserPassword());
		existingUser.setUserEmail(user.getUserEmail());
		existingUser.setUserStatus(user.getUserStatus());
		
		userRepository.save(existingUser);
		
		return existingUser;
	}

	@Override
	public void deleteUser(long userId) {
		userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));;
		userRepository.deleteById(userId);
	}
}