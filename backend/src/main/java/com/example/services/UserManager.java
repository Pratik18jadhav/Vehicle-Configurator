package com.example.services;

import java.util.Optional;

import com.example.entities.User;

public interface UserManager 
{
	public User addUser(User user);
	public boolean validateUser(User user);
	public Optional<User> getUserByUsername(String username);
	
}

