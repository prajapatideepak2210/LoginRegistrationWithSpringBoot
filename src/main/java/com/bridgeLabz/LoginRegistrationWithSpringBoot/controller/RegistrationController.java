package com.bridgeLabz.LoginRegistrationWithSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.Response;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public ResponseEntity<Response> registration(@RequestBody User user){
		Response response = new Response();
		if(user!=null){
			User userForCheck = registrationService.addUser(user);
			if(userForCheck!=null){
				response.setResponseMessage("User Successfully Registered.");
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}
			response.setResponseMessage("User is not registered.");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
		response.setResponseMessage("User is empty.");
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/getUser/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		if(userId!=0){
			User user = registrationService.getuserById(userId);
			if(user!=null){
				return new ResponseEntity<User>( user, HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
}