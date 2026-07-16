package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	public User getUserById(Long id) {
		
		return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id : " + id));
	}
}
