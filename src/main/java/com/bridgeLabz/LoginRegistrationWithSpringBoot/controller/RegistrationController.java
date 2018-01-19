package com.bridgeLabz.LoginRegistrationWithSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.Response;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.service.RegistrationService;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.validation.Validator;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public ResponseEntity<Response> registration(@RequestBody User user){

		Response response = new Response();
		try {
			String validation = Validator.isUserValid(user);
			if(validation==null){
				User userForCheck = registrationService.addUser(user);
				if(userForCheck!=null){
					response.setResponseMessage("User Successfully Registered.");
					return new ResponseEntity<Response>(response, HttpStatus.OK);
				}
				response.setResponseMessage("User is already registered.");
				return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
			}
			response.setResponseMessage(validation);
			return new ResponseEntity<Response>(response, HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			response.setResponseMessage("User could not be registered.");
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}