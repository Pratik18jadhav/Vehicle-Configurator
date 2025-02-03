package com.example.controllers;






	
	
	
	
	

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;
import com.example.services.UserManager;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("")
public class UserController {

	@Autowired
	private UserManager usermanager;

	@PostMapping(value = "/signup")
	public ResponseEntity<User> registerCompany(@RequestBody User user) {
		try {

			User createdUser = usermanager.addUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> validateUser(@RequestBody User user) {

		try {
			boolean success = usermanager.validateUser(user);

			if (success) {
				return ResponseEntity.ok("Login Succesfull");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user name or password");
			}

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some Error Occurred" + e.getMessage());

		}

	}

	@GetMapping(value = "/getuser/{username}")
	public String getMethodName(@PathVariable String username) {
		Optional<User> userOptional = usermanager.getUserByUsername(username);
		if (userOptional.isPresent()) {
			return "user found";
		}

		return "user not found ";
	}


}
