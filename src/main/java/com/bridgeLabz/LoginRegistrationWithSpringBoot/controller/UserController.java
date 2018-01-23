package com.bridgeLabz.LoginRegistrationWithSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUserbyId/{userId}", method=RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		
			User user = userService.getUserById(userId);
			if(user!=null){
				return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value="getAllUsers")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> list = userService.getAllUser();
		if(list!=null){
			return new ResponseEntity<List<User>>(list, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.BAD_REQUEST);
	}
	
}
