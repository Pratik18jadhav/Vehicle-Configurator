package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserRepository userrepository;

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userrepository.save(user);
	}

	public boolean validateUser(User user) {

		return userrepository.validateUser(user.getUsername(), user.getPassword());
	}

	@Override
	public Optional<User> getUserByUsername(String username) {

		return userrepository.findByUsername(username);
	}

}
