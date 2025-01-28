package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.UserRepository;

@Service
public class UserManagerImpl implements UserManager {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	
	

}
