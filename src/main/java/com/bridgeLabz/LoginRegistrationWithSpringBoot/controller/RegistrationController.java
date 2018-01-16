package com.bridgeLabz.LoginRegistrationWithSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.Response;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/registration")
	public ResponseEntity<Response> helloTest(@RequestBody User user){
		Response response = new Response();
		if(user!=null){
			User userForCheck = registrationService.addUser(user);
			if(userForCheck!=null){
				response.setResponseMessage("User Successfully Registered.");
				return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
			}
			response.setResponseMessage("User is not registered.");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
		response.setResponseMessage("User is empty.");
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}
	
}