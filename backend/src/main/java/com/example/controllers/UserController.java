package com.example.controllers;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;
import com.example.jwt.JwtService;
import com.example.services.InvoicePdfManager;
import com.example.services.UserManager;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("")
//@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UserManager usermanager;

	@Autowired
	private AuthenticationManager authmanager;

	@Autowired
	private JwtService jwtService;

	@PostMapping(value = "/signup")
	public ResponseEntity<User> registerCompany(@RequestBody User user) {
		try {

			User createdUser = usermanager.addUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

//	@PostMapping(value = "/login")
//	public ResponseEntity<?> validateUser(@RequestBody User user) {
//
//		try {
//
//			boolean success = usermanager.validateUser(user);
//
//			if (success) {
//				return ResponseEntity.ok("Login Succesfull");
//			} else {
//				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user name or password");
//			}
//
//		} catch (Exception e) {
//
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some Error Occurred" + e.getMessage());
//
//		}
//
//	}

	@PostMapping(value = "/login")
	public String login(@RequestBody User user) {
		
		Authentication authentication = authmanager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if (authentication.isAuthenticated()) {
			
			return jwtService.generateToken(user.getUsername());
		} else {
			return "fail";
		}

	}

	@GetMapping(value = "/getuser/{username}")
	public String getMethodName(@PathVariable String username) {
		User user = usermanager.getUserByUsername(username);
		if (user == null) {
			return "user not found";
		}

		return "user found ";
	}

}
