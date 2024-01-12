package com.rentrabbit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentrabbit.model.User;
import com.rentrabbit.repository.UserRepository;
import com.rentrabbit.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElse(null);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User updatedUser) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			// Update fields based on your requirements
			existingUser.setUsername(updatedUser.getUsername());
			existingUser.setEmail(updatedUser.getEmail());
			// Update other fields as needed
			return userRepository.save(existingUser);
		}
		return null; // User with the given id not found
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
