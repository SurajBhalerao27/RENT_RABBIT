package com.rentrabbit.service;

import java.util.List;

import com.rentrabbit.model.User;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(Long id);

	User createUser(User user);

	User updateUser(Long id, User updatedUser);

	void deleteUser(Long id);
}
